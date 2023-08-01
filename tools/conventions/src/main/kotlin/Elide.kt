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

/** Static library configuration values. */
object Elide {
  /** Name of the library. */
  const val name = "elide"

  /** Major release version for Elide. */
  const val track = "v3"

  /** Major library version. */
  const val majorVersion = "1.0"

  /** Major library version tag. */
  const val versionTag = "alpha4"

  /** Revision value for the library. */
  const val revision = 9

  /** Version string for the library. */
  const val version = "$majorVersion-$track-$versionTag-b$revision"

  /** Latest plugin version. */
  const val pluginVersion = "1.0.0-beta23"

  /** Maven group shared by Elide artifacts. */
  const val group = "dev.elide"

  /** Compiler args to include in all Kotlin targets. */
  val compilerArgs = listOf(
    "-progressive",
    "-Xcontext-receivers",
    "-Xskip-prerelease-check",
  )

  /** Compiler args to include in Kotlin JVM targets. */
  val jvmCompilerArgs = compilerArgs.plus(listOf(
    "-no-stdlib",
    "-Xjvm-default=all",
    "-Xjsr305=strict",
  ))

  /** Compiler args to include in Kotlin JVM targets (beta). */
  val jvmCompilerArgsBeta = jvmCompilerArgs.plus(listOf(
    "-Xallow-unstable-dependencies",
    "-Xemit-jvm-type-annotations",
  ))

  /** Compiler args to include in Kotlin JS targets. */
  val jsCompilerArgs = compilerArgs.plus(listOf(
    "-Xgenerate-dts",
  ))

  /** Compiler args to include in Kotlin MPP targets. */
  val mppCompilerArgs = compilerArgs

  /** Compiler args to include in Kotlin JVM targets which use `kapt`. */
  val kaptCompilerArgs = compilerArgs.plus(listOf(
    "-no-stdlib",
    "-Xallow-unstable-dependencies",
    "-Xemit-jvm-type-annotations",
    "-Xjvm-default=all",
    "-Xjsr305=strict",
  ))

  /** Kotlin SDK and platform version. */
  const val kotlinSdk = "1.9.0"

  /** Kotlin language version. */
  const val kotlinLanguage = "1.9"

  /** Kotlin language version (beta). */
  const val kotlinLanguageBeta = kotlinLanguage

  /** Minimum Java language target. */
  const val javaTargetMinimum = "17"

  /** Maximum Java language target. */
  const val javaTargetMaximum = "19"

  /** Maximum Kotlin JVM language target. */
  const val kotlinJvmTargetMaximum = "20"

  /** Maximum Java language target for Proguard. */
  const val javaTargetProguard = "19"

  /** Sample code modules. */
  val samplesList = listOf(
    ":samples:server:hellocss",
    ":samples:server:helloworld",
    ":samples:fullstack:basic:server",
    ":samples:fullstack:react:server",
    ":samples:fullstack:ssr:server",
    ":samples:fullstack:react-ssr:server",
  )

  /** Kotlin MPP modules. */
  val multiplatformModules = listOf(
    "base",
    "core",
    "model",
    "rpc",
    "ssr",
    "test",
  )

  /** Server-side only modules. */
  val serverModules = listOf(
    "graalvm",
    "server",
    "ssg",
  )

  /** Browser-side only modules. */
  val frontendModules = listOf(
    "frontend",
    "graalvm-js",
    "graalvm-react",
  )

  /** Modules which should not be reported on for testing.. */
  val noTestModules = listOf(
    "bom",
    "platform",
    "packages",
    "processor",
    "reports",
    "bundler",
    "samples",
    "site",
    "ssg",
    "docs",
    "model",
    "benchmarks",
    "frontend",
    "graalvm-js",
    "graalvm-react",
    "test",
  )

  /** All library modules which are published. */
  val publishedModules = listOf(
    // Library Packages
    "base",
    "bom",
    "core",
    "frontend",
    "graalvm",
    "graalvm-js",
    "graalvm-react",
    "model",
    "platform",
    "proto:proto-core",
    "proto:proto-protobuf",
    "proto:proto-flatbuffers",
    "proto:proto-kotlinx",
    "rpc",
    "server",
    "ssg",
    "ssr",
    "test",
  ).map { ":packages:$it" }.plus(listOf(
    // Tools
    "processor",
  ).map { ":tools:$it" })

  /** All subproject modules which are published. */
  val publishedSubprojects = listOf(
    "bom",
    "compiler-util",
    "injekt",
    "interakt",
    "redakt",
    "sekret",
  ).map { ":substrate:$it" }.plus(listOf(
    ":substrate",
    ":conventions",
  ))
}
