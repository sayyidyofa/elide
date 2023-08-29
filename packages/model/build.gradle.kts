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
@file:OptIn(
  org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class
)

import ElidePackages.elidePackage

plugins {
  kotlin("plugin.noarg")
  kotlin("plugin.allopen")
  kotlin("plugin.serialization")

  id("dev.elide.internal.kotlin.redakt")
  id("dev.elide.build.multiplatform")
  id("dev.elide.build.publishable")
}

group = "dev.elide"

val buildMingw = project.properties["buildMingw"] == "true"
val buildWasm = project.properties["buildWasm"] == "true"

kotlin {
  explicitApi()

  jvm {
    compilations.all {
      kotlinOptions {
        apiVersion = libs.versions.kotlin.language.get()
        languageVersion = libs.versions.kotlin.language.get()
      }
    }
    withJava()
    testRuns["test"].executionTask.configure {
      useJUnitPlatform()
    }
  }
  js {
    browser()
    nodejs()
    generateTypeScriptDefinitions()

    compilations.all {
      kotlinOptions {
        sourceMap = true
        moduleKind = "umd"
        metaInfo = true
      }
    }
  }
  if (buildWasm) wasm {
    browser()
    nodejs()
    d8()
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

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib-common"))
        api(projects.packages.base)
        api(projects.packages.core)
        api(libs.kotlinx.collections.immutable)
        api(libs.kotlinx.datetime)
        api(libs.kotlinx.serialization.core)
        api(libs.kotlinx.serialization.json)
        api(libs.kotlinx.serialization.protobuf)
        api(libs.kotlinx.coroutines.core)
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test"))
      }
    }
    val jvmMain by getting {
      dependencies {
        implementation(projects.packages.base)
        implementation(projects.packages.proto.protoCore)
        implementation(projects.packages.proto.protoProtobuf)
        implementation(projects.packages.proto.protoKotlinx)
        implementation(libs.jakarta.inject)
        api(libs.protobuf.java)
        api(libs.protobuf.kotlin)
        api(libs.flatbuffers.java.core)
        implementation(libs.kotlinx.serialization.json.jvm)
        implementation(libs.kotlinx.serialization.protobuf.jvm)
        implementation(libs.kotlinx.coroutines.core.jvm)
        implementation(libs.kotlinx.coroutines.jdk9)
        implementation(libs.kotlinx.coroutines.guava)
        implementation(libs.google.api.common)
        implementation(libs.reactivestreams)
      }
    }
    val jvmTest by getting {
      dependencies {
        implementation(kotlin("test-junit5"))
        implementation(projects.packages.base)
        implementation(libs.truth)
        implementation(libs.truth.proto)
        runtimeOnly(libs.junit.jupiter.engine)
        runtimeOnly(libs.logback)
      }
    }
    val jsMain by getting {
      dependencies {
        // KT-57235: fix for atomicfu-runtime error
        api("org.jetbrains.kotlin:kotlinx-atomicfu-runtime:1.8.20-RC")

        implementation(kotlin("stdlib-js"))
        implementation(projects.packages.base)
        implementation(projects.packages.frontend)
        implementation(libs.kotlinx.coroutines.core.js)
        implementation(libs.kotlinx.serialization.json.js)
        implementation(libs.kotlinx.serialization.protobuf.js)
      }
    }
    val jsTest by getting
    val nativeMain by getting {
      dependencies {
        implementation(kotlin("stdlib"))
        implementation(projects.packages.base)
      }
    }
    val nativeTest by getting

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
      val wasmMain by getting { dependsOn(commonMain) }
      val wasmTest by getting { dependsOn(commonTest) }
    }
  }
}

elidePackage(
  id = "model",
  name = "Elide Model",
  description = "Data and structure modeling runtime package for use with the Elide Framework.",
)
