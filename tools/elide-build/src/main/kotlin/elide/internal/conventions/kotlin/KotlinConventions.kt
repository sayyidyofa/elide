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

import com.google.devtools.ksp.gradle.KspExtension
import com.google.devtools.ksp.gradle.KspTask
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.allopen.gradle.AllOpenExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.internal.KaptTask
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask
import org.jetbrains.kotlin.noarg.gradle.NoArgExtension
import kotlinx.atomicfu.plugin.gradle.AtomicFUPluginExtension
import elide.internal.conventions.Constants.Elide
import elide.internal.conventions.Constants.Kotlin
import elide.internal.conventions.Constants.Versions
import elide.internal.conventions.jvm.configureJavadoc
import elide.internal.conventions.jvm.includeSourceJar
import elide.internal.conventions.kotlin.KotlinTarget.*
import elide.internal.conventions.publishing.publishJavadocJar

private const val DEFAULT_JVM_MINIMUM = 8
private const val DEFAULT_JVM_TARGET = 21

/**
 * Configure a Kotlin project targeting a specific platform. Options passed to this convention are applied to every
 * Kotlin source set.
 *
 * @param explicitApi Whether to enable Explicit API mode for all source sets.
 * @param configureKapt Whether to configure KAPT if present, according to internal conventions.
 * @param configureKsp Whether to configure KSP if present, according to internal conventions.
 * @param configureAllOpen Whether to configure the AllOpen plugin with annotations used often in Elide packages.
 * @param configureAtomicFu Whether to configure the AtomicFu plugin with annotations used often in Elide packages.
 * @param configureNoArgs Whether to configure the NoArgs plugin with annotations used often in Elide packages.
 * @param configureJavaModules Whether to enable processing of `module-info.java` files for JPMS support.
 * @param configureMultiReleaseJar Whether to create a multi-release JAR; must pass [configureJavaModules] as `true`.
 * @param javaTargetRange The range of Java versions to target for multi-release JARs; calculated from target & minimum.
 * @param customKotlinCompilerArgs Custom Kotlin compiler args to apply.
 * @param wasmSourceSets Whether to spawn WASM source sets for use as commons.
 * @param kotlinVersionOverride Override the API and language version of Kotlin for this module only.
 * @param splitJvmTargets Whether to split and carry default source sets for non-JVM targets; defaults to `false`.
 * @param nonJvmSourceSet The name of the non-JVM source set; defaults to `default`.
 * @param jvmSourceSet The name of the JVM source set; defaults to `jvm`. Only used if [splitJvmTargets] is `true`.
 */
internal fun Project.configureKotlinBuild(
  target: KotlinTarget,
  explicitApi: Boolean = false,
  configureKapt: Boolean = false,
  configureKsp: Boolean = false,
  configureAllOpen: Boolean = false,
  configureAtomicFu: Boolean = false,
  configureNoArgs: Boolean = false,
  configureJavaModules: Boolean = false,
  javaMinimum: Int = DEFAULT_JVM_MINIMUM,
  javaTarget: Int = DEFAULT_JVM_TARGET,
  configureMultiReleaseJar: Boolean = false,
  javaTargetRange: IntRange = javaMinimum..javaTarget,
  customKotlinCompilerArgs: List<String> = emptyList(),
  wasmSourceSets: Boolean = false,
  kotlinVersionOverride: String? = null,
  splitJvmTargets: Boolean = false,
  nonJvmSourceSet: String = "default",
  jvmSourceSet: String = "jvm",
  jvmModuleName: String? = null,
) {
  val kotlinVersion = kotlinVersionOverride ?: findProperty(Versions.KOTLIN)?.toString()
  val useStrictMode = findProperty(Kotlin.STRICT_MODE).toString().toBoolean()

  // Maven Central requires a javadoc JAR artifact
  configureJavadoc()
  publishJavadocJar()

  // configure Dokka to depend on code generation tasks
  configureDokka()

  if (configureAtomicFu) {
    apply(plugin = "kotlinx-atomicfu")

    the<AtomicFUPluginExtension>().apply {
      dependenciesVersion = null
      transformJvm = true
      transformJs = true
      jvmVariant = "VH"
    }
  }

  // Multiplatform targets have a few extra settings
  if (target !is JVM) {
    configureKotlinMultiplatform(
      target,
      configureJavaModules,
      splitJvmTargets,
      nonJvmSourceSet,
      jvmSourceSet,
      jvmModuleName,
      javaMinimum,
      javaTarget,
      configureMultiReleaseJar,
      javaTargetRange,
    )
  } else {
    // configure sources JAR generated by the java plugin (only for pure Kotlin/JVM projects)
    includeSourceJar()

    // configure kotlin for jvm
    configureKotlinJvm(
      target,
      configureJavaModules,
      splitJvmTargets,
      jvmModuleName,
      javaMinimum,
      javaTarget,
      configureMultiReleaseJar,
      javaTargetRange,
    )
  }

  // base Kotlin options
  extensions.getByType(KotlinProjectExtension::class.java).apply {
    sourceSets.apply {
      if (wasmSourceSets) {
        val wasmMain = create("wasmMain") {
          findByName("commonMain")?.let { dependsOn(it) }
        }
        val wasmTest = create("wasmTest") {
          findByName("commonTest")?.let { dependsOn(it) }
        }
        (findByName("wasmJsMain") ?: create("wasmJsMain")).apply {
          dependsOn(wasmMain)
        }
        (findByName("wasmJsTest") ?: create("wasmJsTest")).apply {
          dependsOn(wasmTest)
        }
        (findByName("wasmWasiMain") ?: create("wasmWasiMain")).apply {
          dependsOn(wasmMain)
        }
        (findByName("wasmWasiTest") ?: create("wasmWasiTest")).apply {
          dependsOn(wasmTest)
        }
      }
    }
    sourceSets.all {
      languageSettings {
        if (explicitApi) explicitApi()
        progressiveMode = false
        optIn("kotlin.ExperimentalUnsignedTypes")
      }
    }
  }
  // Kotlin compilation tasks
  tasks.withType(KotlinCompilationTask::class.java).configureEach {
    compilerOptions {
      val kotlinVersionParsed = KotlinVersion.fromVersion(kotlinVersion ?: Versions.KOTLIN_DEFAULT)
      apiVersion.set(kotlinVersionParsed)
      languageVersion.set(kotlinVersionParsed)
      allWarningsAsErrors.set(useStrictMode)
      progressiveMode.set(kotlinVersion != "2.0" && useStrictMode)  // progressive mode makes no sense for bleeding-edge

      if (this is KotlinJvmCompilerOptions) {
        javaParameters.set(true)
      }

      freeCompilerArgs.set(freeCompilerArgs.get().plus(when (target) {
       JVM -> if (configureKapt) Elide.KaptCompilerArgs else Elide.JvmCompilerArgs
       JsBrowser, JsNode -> Elide.JsCompilerArgs
       is Multiplatform, Native, NativeEmbedded, WASM, WASI -> Elide.KmpCompilerArgs
     }).plus(customKotlinCompilerArgs).toList())
    }
  }

  // configure kapt extension
  if (configureKapt) extensions.getByType(KaptExtension::class.java).apply {
    useBuildCache = true
    strictMode = true
    correctErrorTypes = true
    keepJavacAnnotationProcessors = true
    includeCompileClasspath = false
  }

  // configure KSP extension
  if (configureKsp) extensions.getByType(KspExtension::class.java).apply {
    allowSourcesFromOtherPlugins = true
  }

  // configure AllOpen plugin
  if (configureAllOpen) extensions.getByType(AllOpenExtension::class.java).apply {
    annotation("io.micronaut.aop.Around")
  }

  // configure NoArgs plugin
  if (configureNoArgs) extensions.getByType(NoArgExtension::class.java).apply {
    annotation("elide.annotations.Model")
  }
}

/** Configure Dokka tasks to depend on KAPT or KSP generation tasks. */
internal fun Project.configureDokka() {
  // dokka should run after KAPT tasks are done (dokkaHtml for KMP projects, dokkaJavadoc for pure JVM)
  if (plugins.hasPlugin("org.jetbrains.kotlin.kapt")) {
    val kaptTasks = tasks.withType(KaptTask::class.java)
    tasks.findByName("dokkaHtml")?.dependsOn(kaptTasks)
    tasks.findByName("dokkaHtmlPartial")?.dependsOn(kaptTasks)
    tasks.findByName("dokkaJavadoc")?.dependsOn(kaptTasks)
  }

  // same principle applies to KSP tasks
  if (plugins.hasPlugin("com.google.devtools.ksp")) {
    val kspTasks = tasks.withType(KspTask::class.java)
    tasks.findByName("dokkaHtml")?.dependsOn(kspTasks)
    tasks.findByName("dokkaHtmlPartial")?.dependsOn(kspTasks)
  }

  // if dokka is applied, we must depend on C-interop tasks
  if (plugins.hasPlugin("org.jetbrains.dokka")) {
    tasks.findByName("dokkaHtml")?.apply {
      tasks.findByName("transformNativeMainCInteropDependenciesMetadataForIde")?.let {
        dependsOn(it)
      }
    }
  }
}
