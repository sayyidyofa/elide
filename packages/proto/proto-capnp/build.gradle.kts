@file:Suppress(
  "UnstableApiUsage",
  "unused",
  "DSL_SCOPE_VIOLATION",
  "UNUSED_VARIABLE",
)

plugins {
  `maven-publish`
  distribution
  signing
  id("dev.elide.build.kotlin")
}

group = "dev.elide"
version = rootProject.version as String

val javaLanguageVersion = project.properties["versions.java.language"] as String
val javaLanguageTarget = project.properties["versions.java.target"] as String

sourceSets {
  val main by getting
  val test by getting
}

configurations {
  // `capnInternal` uses the Cap'N'Proto implementation only, rather than the full cruft of Protocol Buffers non-lite.
  create("capnInternal") {
    isCanBeResolved = false
    isCanBeConsumed = true

    extendsFrom(configurations["implementation"])
  }
}

kotlin {
  target.compilations.all {
    kotlinOptions {
      jvmTarget = javaLanguageTarget
      javaParameters = true
      apiVersion = Elide.kotlinLanguage
      languageVersion = Elide.kotlinLanguage
      allWarningsAsErrors = false
      freeCompilerArgs = Elide.jvmCompilerArgsBeta.plus(listOf(
        // do not warn for generated code
        "-nowarn"
      ))
    }
  }

  // force -Werror to be off
  afterEvaluate {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
      kotlinOptions.allWarningsAsErrors = false
    }
  }
}

tasks.withType<JavaCompile>().configureEach {
  sourceCompatibility = javaLanguageTarget
  targetCompatibility = javaLanguageTarget
  options.isFork = true
  options.isIncremental = true
  options.isWarnings = false
}

tasks {
  test {
    useJUnitPlatform()
  }

  /**
   * Variant: Cap'N'Proto
   */
//  val compileCapnProtos by creating(FlatBuffers::class) {
//    description = "Generate Flatbuffers code for Kotlin/JVM"
//    inputDir = file("${rootProject.projectDir}/proto")
//    outputDir = file("$projectDir/src/main/flat")
//  }

//  artifacts {
//    archives(jar)
//    add("flatInternal", jar)
//  }

//  val sourcesJar by registering(Jar::class) {
//    dependsOn(JavaPlugin.CLASSES_TASK_NAME)
//    archiveClassifier.set("sources")
//    from(sourceSets["main"].allSource)
//  }
}

val buildDocs = project.properties["buildDocs"] == "true"
val javadocJar: TaskProvider<Jar>? = if (buildDocs) {
  val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class)

  val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn(dokkaHtml)
    archiveClassifier.set("javadoc")
    from(dokkaHtml.outputDirectory)
  }
  javadocJar
} else null

publishing {
  publications {
    /** Publication: Cap'n'proto */
    create<MavenPublication>("maven") {
      artifactId = artifactId.replace("proto-capn", "elide-proto-capn")
      from(components["kotlin"])
      artifact(tasks["kotlinSourcesJar"])
      if (buildDocs) {
        artifact(javadocJar)
      }

      pom {
        name.set("Elide Protocol: Cap'n'Proto")
        description.set("Elide protocol implementation for Cap'n'Proto")
        url.set("https://elide.dev")
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
}

dependencies {
  // Common
  api(libs.kotlinx.datetime)
  implementation(kotlin("stdlib"))
  implementation(kotlin("stdlib-jdk8"))
  implementation(project(":packages:core"))
  implementation(project(":packages:base"))
  testImplementation(project(":packages:test"))
  testImplementation(libs.truth)
  testImplementation(libs.truth.java8)

  // Variant: Cap'n'Proto
  api(project(":packages:proto:proto-core"))
  implementation(kotlin("stdlib"))
  implementation(kotlin("stdlib-jdk8"))
  implementation(libs.capnproto)
  testImplementation(project(":packages:proto:proto-core", configuration = "testBase"))
}

afterEvaluate {
  tasks.named("runKtlintCheckOverMainSourceSet").configure {
    enabled = false
  }
}