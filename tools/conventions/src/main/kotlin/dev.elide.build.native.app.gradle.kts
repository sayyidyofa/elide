@file:Suppress("UnstableApiUsage")

plugins {
  kotlin("plugin.serialization")
  id("org.graalvm.buildtools.native")
  id("dev.elide.build.jvm.kapt")
}

val quickbuild = (
  project.properties["elide.release"] != "true" ||
  project.properties["elide.buildMode"] == "dev"
)

afterEvaluate {
  tasks.named("testNativeImage") {
    enabled = false
  }
}

graalvmNative {
  testSupport = true

  metadataRepository {
    enabled = true
    version = GraalVMVersions.graalvmMetadata
  }

  agent {
    defaultMode = "standard"
    builtinCallerFilter = true
    builtinHeuristicFilter = true
    enableExperimentalPredefinedClasses = false
    enableExperimentalUnsafeAllocationTracing = false
    trackReflectionMetadata = true
    enabled = true

    modes {
      standard {}
    }
    metadataCopy {
      inputTaskNames.add("test")
      outputDirectories.add("src/main/resources/META-INF/native-image")
      mergeWithExisting = true
    }
  }

  binaries {
    named("main") {
      fallback = false
      quickBuild = quickbuild
      buildArgs.addAll(listOf(
        "--language:js",
        "--language:regex",
        "--enable-all-security-services",
        "-Dpolyglot.image-build-time.PreinitializeContexts=js",
      ))

      javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of((project.properties["versions.java.language"] as String))
        if (project.hasProperty("elide.graalvm.variant")) {
          val variant = project.property("elide.graalvm.variant") as String
          if (variant != "COMMUNITY") {
            vendor = JvmVendorSpec.matching(when (variant.trim()) {
              "ENTERPRISE" -> "Oracle"
              else -> "GraalVM Community"
            })
          }
        }
      }
    }

    named("optimized") {
      fallback = false
      quickBuild = quickbuild
      buildArgs.addAll(listOf(
        "--language:js",
        "--language:regex",
        "-O2",
        "--enable-all-security-services",
        "-Dpolyglot.image-build-time.PreinitializeContexts=js",
      ))

      javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of((project.properties["versions.java.language"] as String))
        if (project.hasProperty("elide.graalvm.variant")) {
          val variant = project.property("elide.graalvm.variant") as String
          if (variant != "COMMUNITY") {
            vendor = JvmVendorSpec.matching(when (variant.trim()) {
              "ENTERPRISE" -> "Oracle"
              else -> "GraalVM Community"
            })
          }
        }
      }
    }

    named("test") {
      buildArgs.addAll(listOf(
        "--language:js",
        "--language:regex",
        "--enable-all-security-services",
        "-Dpolyglot.image-build-time.PreinitializeContexts=js",
      ))

      quickBuild = quickbuild
      javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of((project.properties["versions.java.language"] as String))
        if (project.hasProperty("elide.graalvm.variant")) {
          val variant = project.property("elide.graalvm.variant") as String
          if (variant != "COMMUNITY") {
            vendor = JvmVendorSpec.matching(when (variant.trim()) {
              "ENTERPRISE" -> "Oracle"
              else -> "GraalVM Community"
            })
          }
        }
      }
    }
  }
}
