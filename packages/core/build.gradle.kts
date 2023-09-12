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

@file:Suppress(
  "UnstableApiUsage",
  "unused",
  "UNUSED_VARIABLE",
  "DSL_SCOPE_VIOLATION",
  "OPT_IN_USAGE",
)

import ElidePackages.elidePackage

plugins {
  kotlin("kapt")
  id("dev.elide.build")
  id("dev.elide.build.publishable")
  id("dev.elide.build.multiplatform")
}

group = "dev.elide"
version = rootProject.version as String

val buildMingw = project.properties["buildMingw"] == "true"
val buildWasm = project.properties["buildWasm"] == "true"
val kotlinVersion: String = project.properties["versions.kotlin.sdk"] as String

kotlin {
  explicitApi()

  jvm {
    withJava()
  }

  js {
    nodejs()
    browser()
    generateTypeScriptDefinitions()

    compilations.all {
      kotlinOptions {
        sourceMap = true
        moduleKind = "umd"
        metaInfo = true
      }
    }
  }

  macosArm64()
  iosArm64()
  iosX64()
  watchosArm32()
  watchosArm64()
  watchosX64()
  tvosArm64()
  tvosX64()
  if (buildMingw) mingwX64()

  if (buildWasm) {
    wasmJs {
      nodejs()
      d8()
      browser()
    }
    wasmWasi {
      // nothing yet
    }
  }

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib"))
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(kotlin("stdlib"))
        implementation(kotlin("test"))

        configurations["kapt"].dependencies.add(
          mn.micronaut.inject.java.asProvider().get()
        )
      }
    }
    val jvmMain by getting {
      dependencies {
        api(kotlin("stdlib-jdk8"))
        api(libs.jetbrains.annotations)
      }
    }
    val jvmTest by getting {
      dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("test"))
      }
    }
    val jsMain by getting {
      dependencies {
        implementation(kotlin("stdlib-js"))
      }
    }
    val jsTest by getting {
      dependencies {
        implementation(kotlin("stdlib-js"))
        implementation(kotlin("test"))
      }
    }
    val nativeMain by getting {
      dependencies {
        implementation(kotlin("stdlib"))
      }
    }
    val nativeTest by getting {
      dependencies {
        implementation(kotlin("stdlib"))
        implementation(kotlin("test"))
      }
    }

    if (buildMingw) {
      val mingwX64Main by getting { dependsOn(nativeMain) }
    }
    val macosArm64Main by getting { dependsOn(nativeMain) }
    val iosArm64Main by getting { dependsOn(nativeMain) }
    val iosX64Main by getting { dependsOn(nativeMain) }
    val watchosArm32Main by getting { dependsOn(nativeMain) }
    val watchosArm64Main by getting { dependsOn(nativeMain) }
    val watchosX64Main by getting { dependsOn(nativeMain) }
    val tvosArm64Main by getting { dependsOn(nativeMain) }
    val tvosX64Main by getting { dependsOn(nativeMain) }
    if (buildWasm) {
      val wasmJsMain by getting {
        dependsOn(commonMain)
      }
      val wasmJsTest by getting {
        dependsOn(commonTest)
      }
      val wasmWasiMain by getting {
        dependsOn(commonMain)
      }
      val wasmWasiTest by getting {
        dependsOn(commonTest)
      }
    }
  }
}

elidePackage(
  id = "core",
  name = "Elide Core",
  description = "Pure Kotlin utilities provided across all supported platforms for the Elide Framework.",
)

configurations.all {
  resolutionStrategy.eachDependency {
    if (requested.group == "org.jetbrains.kotlin" && requested.name.contains("stdlib")) {
      useVersion(kotlinVersion)
      because("pin kotlin stdlib")
    }
  }
}
