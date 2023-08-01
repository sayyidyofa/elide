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
  "DSL_SCOPE_VIOLATION",
  "UNUSED_VARIABLE",
)

import kotlinx.benchmark.gradle.*
import Java9Modularity.configure as configureJava9ModuleInfo

plugins {
  id("io.micronaut.library")
  id("io.micronaut.graalvm")

  kotlin("plugin.allopen")
  id("dev.elide.build.native.lib")
  alias(libs.plugins.jmh)
  alias(libs.plugins.kotlinx.plugin.benchmark)
}

allOpen {
  annotation("org.openjdk.jmh.annotations.State")
}

group = "dev.elide"
version = rootProject.version as String
val encloseSdk = false

kotlin {
  explicitApi()
}

sourceSets {
  val benchmarks by creating {
    kotlin.srcDirs(
      "$projectDir/src/benchmarks/kotlin",
      "$projectDir/src/main/kotlin",
    )
  }
}

val initializeAtBuildTime = listOf(
  "kotlin.DeprecationLevel",
  "kotlin.annotation.AnnotationRetention",
  "kotlin.annotation.AnnotationTarget",
  "kotlin.coroutines.intrinsics.CoroutineSingletons",
)

val initializeAtBuildTimeTest = listOf(
  "org.junit.jupiter.engine.config.InstantiatingConfigurationParameterConverter",
  "org.junit.platform.launcher.core.LauncherConfig",
)

graalvmNative {
  testSupport = true

  agent {
    enabled = false
  }

  binaries {
    create("shared") {
      sharedLibrary = true
      buildArgs(
        initializeAtBuildTime.map {
        "--initialize-at-build-time=$it"
      }.plus(emptyList()),
      )
    }

    named("test") {
      fallback = false
      sharedLibrary = false
      quickBuild = true
      buildArgs(
        initializeAtBuildTime.plus(initializeAtBuildTimeTest).map {
        "--initialize-at-build-time=$it"
      }.plus(emptyList()),
      )
    }
  }
}

benchmark {
  configurations {
    named("main") {
      warmups = 10
      iterations = 5
    }
  }
  targets {
    register("benchmarks") {
      this as JvmBenchmarkTarget
      jmhVersion = libs.versions.jmh.lib.get()
    }
  }
}

micronaut {
  enableNativeImage(true)
  version = libs.versions.micronaut.lib.get()
  processing {
    incremental = true
    annotations.addAll(
      listOf(
      "elide.runtime.*",
      "elide.runtime.gvm.*",
      "elide.runtime.gvm.internals.*",
      "elide.runtime.gvm.intrinsics.*",
    ),
    )
  }
}

configurations["benchmarksImplementation"].extendsFrom(
  configurations.implementation.get(),
  configurations.testImplementation.get(),

)
configurations["benchmarksRuntimeOnly"].extendsFrom(
  configurations.runtimeOnly.get(),
  configurations.testRuntimeOnly.get(),
)

dependencies {
  // API Deps
  api(libs.jakarta.inject)

  // Modules
  api(project(":packages:base"))
  api(project(":packages:core"))
  api(project(":packages:wasm"))
  api(project(":packages:ssr"))

  // Kotlin / KotlinX
  implementation(kotlin("stdlib"))
  implementation(kotlin("reflect"))
  implementation(libs.kotlinx.coroutines.core)
  implementation(libs.kotlinx.coroutines.jdk9)
  implementation(libs.kotlinx.coroutines.core.jvm)
  implementation(libs.kotlinx.serialization.core.jvm)
  implementation(libs.kotlinx.serialization.json.jvm)
  runtimeOnly(libs.kotlinx.coroutines.reactor)

  // General
  implementation(libs.jimfs)
  implementation(libs.lmax.disruptor.core)

  // Compression
  implementation(libs.commons.compress)

  // Micronaut
  runtimeOnly(libs.micronaut.graal)
  implementation(libs.micronaut.http)
  implementation(libs.micronaut.context)
  implementation(libs.micronaut.inject)

  // Reactor Netty
  implementation(libs.reactor.netty)

  // SQLite
  implementation(libs.sqlite)

  implementation(project(":packages:proto:proto-core"))
  implementation(project(":packages:proto:proto-protobuf"))
  implementation(project(":packages:proto:proto-kotlinx"))
  implementation(project(":packages:proto:proto-flatbuffers"))

  if (encloseSdk) {
    compileOnly(libs.graalvm.sdk)
    compileOnly(libs.graalvm.truffle.api)
  }

  // Testing
  testImplementation(project(":packages:test"))
  testImplementation(libs.kotlinx.coroutines.test)
  testImplementation(libs.junit.jupiter.api)
  testImplementation(libs.junit.jupiter.params)
  testImplementation(libs.micronaut.test.junit5)
  testRuntimeOnly(libs.junit.jupiter.engine)

  if (encloseSdk) {
    testCompileOnly(libs.graalvm.sdk)
  }
}

configureJava9ModuleInfo(project)

tasks {
  test {
    maxHeapSize = "2G"
    maxParallelForks = 4
  }
}

publishing {
  publications.withType<MavenPublication> {
    artifactId = artifactId.replace("graalvm", "elide-graalvm")

    pom {
      name = "Elide for GraalVM"
      url = "https://elide.dev"
      description = "Integration package with GraalVM and GraalJS."

      licenses {
        license {
          name = "MIT License"
          url = "https://github.com/elide-dev/elide/blob/v3/LICENSE"
        }
      }
      developers {
        developer {
          id = "sgammon"
          name = "Sam Gammon"
          email = "samuel.gammon@gmail.com"
        }
      }
      scm {
        url = "https://github.com/elide-dev/elide"
      }
    }
  }
}
