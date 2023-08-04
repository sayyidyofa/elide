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

import Java9Modularity.configure as configureJava9ModuleInfo

plugins {
  kotlin("kapt")
  id("dev.elide.build")
  id("dev.elide.build.publishable")
  id("dev.elide.build.multiplatform")
}

group = "dev.elide"
version = rootProject.version as String

val buildMingw = project.properties["buildMingw"] == "true"

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

  wasm {
    nodejs()
    d8()
    browser()
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
          libs.micronaut.inject.java.asProvider().get()
        )
      }
    }
    val jvmMain by getting {
      dependencies {
        api(kotlin("stdlib-jdk8"))
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
    val wasmMain by getting {
      dependsOn(nativeMain)
      dependencies {
        implementation(kotlin("stdlib-wasm"))
      }
    }
  }
}

configureJava9ModuleInfo(project)

val buildDocs = project.properties["buildDocs"] == "true"
val javadocJar: TaskProvider<Jar>? = if (buildDocs) {
  val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class)

  val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn(dokkaHtml)
    archiveClassifier = "javadoc"
    from(dokkaHtml.outputDirectory)
  }
  javadocJar
} else null

tasks.jvmJar {
  duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

publishing {
  publications.withType<MavenPublication> {
    if (buildDocs) {
      artifact(javadocJar)
    }
    artifactId = artifactId.replace("core", "elide-core")

    pom {
      name = "Elide Core"
      url = "https://elide.dev"
      description = (
              "Pure Kotlin utilities provided across all supported platforms for the Elide Framework."
              )

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
