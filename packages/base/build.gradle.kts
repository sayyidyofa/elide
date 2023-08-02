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
)
@file:OptIn(
    org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class,
)

import Java9Modularity.configure as configureJava9ModuleInfo

plugins {
    id("dev.elide.build")
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

    js(IR) {
        browser {}
        nodejs {}
    }
    macosArm64()
    iosArm64()
    iosX64()
    watchosArm32()
    watchosArm64()
    watchosX64()
    tvosArm64()
    tvosX64()

    wasm {
        nodejs()
        d8()
    }

    if (buildMingw) mingwX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                api(projects.packages.core)
                implementation(libs.elide.uuid)
                api(libs.kotlinx.collections.immutable)
                api(libs.kotlinx.datetime)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("stdlib"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                api(libs.slf4j)
                api(libs.jakarta.inject)
                api(libs.micronaut.inject.java)
                api(libs.kotlinx.collections.immutable)
                api(libs.kotlinx.datetime)
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.kotlinx.coroutines.core.jvm)
                implementation(libs.kotlinx.coroutines.jdk9)
                implementation(libs.kotlinx.coroutines.slf4j)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation(kotlin("test-junit5"))
                implementation(libs.junit.jupiter)
                runtimeOnly(libs.junit.jupiter.engine)
                runtimeOnly(libs.logback)
            }
        }
        val jsMain by getting {
            dependencies {
                // KT-57235: fix for atomicfu-runtime error
                api("org.jetbrains.kotlin:kotlinx-atomicfu-runtime:1.8.20-RC")
                implementation(kotlin("stdlib-js"))
                implementation(libs.kotlinx.coroutines.core.js)
                implementation(libs.kotlinx.serialization.json.js)
                api(libs.kotlinx.collections.immutable)
                api(libs.kotlinx.datetime)
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
                implementation(libs.kotlinx.coroutines.core)
                api(libs.kotlinx.collections.immutable)
                api(libs.kotlinx.datetime)
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
        val wasmMain by getting { dependsOn(commonMain) }
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
        artifactId = artifactId.replace("base", "elide-base")

        pom {
            name = "Elide Base"
            url = "https://elide.dev"
            description = (
                "Baseline logic and utilities which are provided for most supported Kotlin and Elide platforms."
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

afterEvaluate {
    tasks.named("compileTestDevelopmentExecutableKotlinJs") {
        enabled = false
    }
    tasks.named("compileTestDevelopmentExecutableKotlinWasm") {
        enabled = false
    }
}
