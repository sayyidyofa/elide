/*
 * Copyright (c) 2023 Elide Ventures, LLC.
 *
 * Licensed under the MIT license (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   https://opensource.org/license/mit/
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under the License.
 */

package elide.internal.conventions.kotlin

import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.tasks.AbstractPublishToMaven
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import elide.internal.conventions.jvm.configureJavaModularity
import elide.internal.conventions.kotlin.KotlinTarget.*

/**
 * Configure a Kotlin Multiplatform project.
 *
 * If the [target] includes Kotlin/JVM, the [configureJavaModules] argument controls whether JPMS build is enabled.
 * Maven publications are automatically configured for each target in multiplatform projects.
 */
@OptIn(ExperimentalWasmDsl::class)
internal fun Project.configureKotlinMultiplatform(
  target: KotlinTarget,
  configureJavaModules: Boolean,
  splitJvmTargets: Boolean,
  nonJvmSourceSet: String,
  jvmSourceSet: String,
) {
  // quick sanity check (JVM is not allowed as a pure target, only as part of a KMP target)
  require(target !is JVM) { "Kotlin JVM target should use the Multiplatform plugin." }

  extensions.getByType(KotlinMultiplatformExtension::class.java).apply {
    // add JVM target
    if (JVM in target) jvm {
      withJava()

      // java modules support
      if(configureJavaModules) configureJavaModularity()

      // use JUnit5 runner
      testRuns.getByName("test").executionTask.configure { useJUnitPlatform() }
    }

    // add JS targets
    if (JsBrowser in target || JsNode in target) js {
      // common options
      generateTypeScriptDefinitions()
      useEsModules()

      compilations.all {
        kotlinOptions {
          sourceMap = true
          moduleKind = "umd"
          metaInfo = true
        }
      }

      if (JsNode in target) nodejs {
        useEsModules()
        generateTypeScriptDefinitions()
      }
      if (JsBrowser in target) browser {
        useEsModules()
        generateTypeScriptDefinitions()
      }
    }

    if (WASM in target || WASI in target) {
      if (WASM in target) wasmJs {
        nodejs()
        browser()
      }
      wasmWasi {
        nodejs()
        applyBinaryen()
      }
    }

    // add native targets
    if (Native in target || NativeEmbedded in target) registerNativeTargets(
      this@configureKotlinMultiplatform,
      all = Native in target,
    )

    // main host publication lock (for KMP projects targeting platforms without cross-compilation)
    if (project.findProperty("publishMainHostLock") == "true") {
      // the "Main Host" (e.g. a Linux-based GitHub runner) will publish the JVM, JS, and Common targets,
      // other hosts will not configure these publications, instead pushing only their platform-specific components
      val publicationsFromMainHost = listOf(jvm(), js()).map { it.name } + "kotlinMultiplatform"

      project.extensions.getByType(PublishingExtension::class.java).publications.matching {
        it.name in publicationsFromMainHost
      }.all {
        tasks.withType(AbstractPublishToMaven::class.java)
          .matching { it.publication == this@all }
          .configureEach { onlyIf { findProperty("isMainHost") == "true" } }
      }
    }

    // if "split JVM targets" are requested, then we need to institute a default (or baseline) source-set for all non-
    // JVM source sets.
    //
    // this is accomplished by looping over each one, ignoring `jvmSourceSet`, and installing the provided
    // `nonJvmSourceSet` as a dependency.
    if (splitJvmTargets) {
      val nonJvmMain = sourceSets.findByName("${nonJvmSourceSet}Main")
      val nonJvmTest = sourceSets.findByName("${nonJvmSourceSet}Test")

      if (nonJvmMain != null || nonJvmTest != null) sourceSets.all {
        if (name.startsWith("common")) {
          // special case: skip common source sets to avoid circular dependency.
          return@all
        }

        if (name != jvmSourceSet && !name.startsWith(jvmSourceSet)) {
          if (name.contains("Main")) {
            if (nonJvmMain != null) {
              dependsOn(nonJvmMain)
            }
          } else if (name.contains("Test")) {
            if (nonJvmTest != null) {
              dependsOn(nonJvmTest)
            }
          }
        }
      } else {
        project.logger.warn("Unable to find non-JVM source set '$nonJvmSourceSet'.")
      }
    }
  }
}

private fun KotlinMultiplatformExtension.registerNativeTargets(project: Project, all: Boolean = false) {
  // Linux
  linuxX64()
  linuxArm64()

  // macOS
  macosX64()
  macosArm64()

  if (project.properties["buildMingw"] != "false") {
    mingwX64()
  }

  if (all) {
    // iOS
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    // watchOS
    watchosArm32()
    watchosArm64()
    watchosX64()
    watchosSimulatorArm64()
    watchosDeviceArm64()

    // tvOS
    tvosArm64()
    tvosX64()
    tvosSimulatorArm64()

    // Android Native
    if (project.properties["buildAndroid"] != "false") {
      androidNativeX86()
      androidNativeX64()
      androidNativeArm32()
      androidNativeArm64()
    }
  }

  sourceSets.apply {
    val commonMain = getByName("commonMain").apply {
      dependencies {
        implementation(kotlin("stdlib"))
      }
    }
    val commonTest = getByName("commonTest").apply {
      dependencies { implementation(kotlin("test")) }
    }
    
    // add an intermediate common target for native
    val nativeMain = create("nativeMain") { dependsOn(commonMain) }
    val nativeTest = create("nativeTest") { dependsOn(commonTest) }

    val nativeTargetSuites: MutableList<Pair<String, String>> = ArrayList()
    nativeTargetSuites.add("linuxX64Main" to "linuxX64Test")
    nativeTargetSuites.add("linuxArm64Main" to "linuxArm64Test")
    nativeTargetSuites.add("macosX64Main" to "macosX64Test")
    nativeTargetSuites.add("macosArm64Main" to "macosArm64Test")
    if (project.properties["buildMingw"] != "false") {
      nativeTargetSuites.add("mingwX64Main" to "mingwX64Test")
    }

    if (all) {
      nativeTargetSuites.add("iosX64Main" to "iosX64Test")
      nativeTargetSuites.add("iosArm64Main" to "iosArm64Test")
      nativeTargetSuites.add("iosSimulatorArm64Main" to "iosSimulatorArm64Test")
      nativeTargetSuites.add("watchosArm32Main" to "watchosArm32Test")
      nativeTargetSuites.add("watchosArm64Main" to "watchosArm64Test")
      nativeTargetSuites.add("watchosX64Main" to "watchosX64Test")
      nativeTargetSuites.add("watchosSimulatorArm64Main" to "watchosSimulatorArm64Test")
      nativeTargetSuites.add("watchosDeviceArm64Main" to "watchosDeviceArm64Test")
      nativeTargetSuites.add("tvosArm64Main" to "tvosArm64Test")
      nativeTargetSuites.add("tvosX64Main" to "tvosX64Test")
      nativeTargetSuites.add("tvosSimulatorArm64Main" to "tvosSimulatorArm64Test")
      nativeTargetSuites.add("androidNativeX86Main" to "androidNativeX86Test")
      nativeTargetSuites.add("androidNativeX64Main" to "androidNativeX64Test")
      nativeTargetSuites.add("androidNativeArm32Main" to "androidNativeArm32Test")
      nativeTargetSuites.add("androidNativeArm64Main" to "androidNativeArm64Test")
    }

    nativeTargetSuites.forEach { (main, test) ->
      findByName(main)?.apply { dependsOn(nativeMain) }
      findByName(test)?.apply { dependsOn(nativeTest) }
    }
  }
}
