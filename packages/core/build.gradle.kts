@file:Suppress(
    "UnstableApiUsage",
    "unused",
    "UNUSED_VARIABLE",
    "DSL_SCOPE_VIOLATION",
    "OPT_IN_USAGE",
)

import ElideTargetSuite.configureMultiReleaseJar
import Java9Modularity.configureJava9ModuleInfo

plugins {
    kotlin("kapt")
    id("dev.elide.build")
    id("dev.elide.build.publishable")
    id("dev.elide.build.multiplatform.core")
}

group = "dev.elide"
version = rootProject.version as String

kotlin {
    explicitApi()

    jvm {
        withJava()
        jvmToolchain(Elide.javaTargetMinimum)
    }

    js(IR) {
        compilations.all {
            kotlinOptions {
                sourceMap = true
                moduleKind = "umd"
                metaInfo = true
            }
        }
        nodejs {}
        browser {}
    }

    macosArm64()
    iosArm64()
    iosX64()
    watchosArm32()
    watchosArm64()
    watchosX64()
    tvosArm64()
    tvosX64()
    mingwX64()
    wasm {
        browser {
            testTask {
                useKarma {
                    this.webpackConfig.experiments.add("topLevelAwait")
                    useChromeHeadless()
                    useConfigDirectory(project.projectDir.resolve("karma.config.d").resolve("wasm"))
                }
            }
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

        val mingwX64Main by getting { dependsOn(nativeMain) }
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

// release at each target level
configureJava9ModuleInfo(multiRelease = true)
configureMultiReleaseJar()

val buildDocs = project.properties["buildDocs"] == "true"
val javadocJar: TaskProvider<Jar>? = if (buildDocs) {
    val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class) {
        dependsOn("kaptKotlinJvm")
    }

    val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
        dependsOn(dokkaHtml)
        archiveClassifier.set("javadoc")
        from(dokkaHtml.outputDirectory)
    }
    javadocJar
} else null

publishing {
    publications.withType<MavenPublication> {
        if (buildDocs) {
            artifact(javadocJar)
        }
        artifactId = artifactId.replace("core", "elide-core")

        pom {
            name.set("Elide Core")
            url.set("https://elide.dev")
            description.set(
                "Pure Kotlin utilities provided across all supported platforms for the Elide Framework."
            )

            licenses {
                license {
                    name.set("MIT License")
                    url.set("https://github.com/elide-dev/elide/blob/v3/LICENSE")
                }
            }
            developers {
                developer {
                    id.set("sgammon")
                    name.set("Sam Gammon")
                    email.set("samuel.gammon@gmail.com")
                }
            }
            scm {
                url.set("https://github.com/elide-dev/elide")
            }
        }
    }
}

afterEvaluate {
    val jvmCompileTasks = listOf(
        "compileKotlinJvmJava11",
        "compileKotlinJvmJava17",
        "compileKotlinJvmJava19",
    ).mapNotNull {
        try {
            tasks.named(it)
        } catch (err: Throwable) {
            null
        }
    }

    val jvmTestTasks = listOf(
        "compileTestKotlinJvmJava11",
        "compileTestKotlinJvmJava17",
        "compileTestKotlinJvmJava19",
    ).mapNotNull {
        try {
            tasks.named(it)
        } catch (err: Throwable) {
            null
        }
    }

    listOf(
        "jvmTest",
        "jvmApiBuild",
        "koverGenerateArtifact",
    ).forEach {
        try {
            tasks.named(it).configure {
                dependsOn(jvmCompileTasks)
            }
        } catch (err: Throwable) {
            // ignore
        }
    }

    listOf(
        "jvmTest",
    ).forEach {
        try {
            tasks.named(it).configure {
                dependsOn(jvmTestTasks)
            }
        } catch (err: Throwable) {
            // ignore
        }
    }

    val signingTasks = listOf(
        "signJvmPublication",
        "signJsPublication",
        "signKotlinMultiplatformPublication",
        "signNativePublication",
        "signIosArm64Publication",
        "signIosX64Publication",
        "signMacosArm64Publication",
        "signWasmPublication",
        "signMingwX64Publication",
        "signTvosArm64Publication",
        "signTvosX64Publication",
        "signWatchosX64Publication",
        "signWatchosArm32Publication",
        "signWatchosArm64Publication",
    ).mapNotNull {
        try {
            tasks.named(it)
        } catch (err: Throwable) {
            null
        }
    }

    listOf(
        "publishJsPublicationToElideRepository",
        "publishJvmPublicationToElideRepository",
        "publishKotlinMultiplatformPublicationToElideRepository",
        "publishNativePublicationToElideRepository",
        "publishIosArm64PublicationToElideRepository",
        "publishIosX64PublicationToElideRepository",
        "publishMacosArm64PublicationToElideRepository",
        "publishWasmPublicationToElideRepository",
        "publishMingwX64PublicationToElideRepository",
        "publishTvosArm64PublicationToElideRepository",
        "publishTvosX64PublicationToElideRepository",
        "publishWatchosArm32PublicationToElideRepository",
        "publishWatchosArm64PublicationToElideRepository",
        "publishWatchosX64PublicationToElideRepository",
    ).forEach {
        try {
            tasks.named(it).configure {
                dependsOn(signingTasks)
            }
        } catch (err: Throwable) {
            // ignore
        }
    }
}
