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

package elide.internal.conventions.project

public object Projects {
  /** Modules which should not be reported on for testing. */
  public val noTestModules: List<String> = listOf(
    "bom",
    "platform",
    "packages",
    "processor",
    "reports",
    "bundler",
    "samples",
    "site",
    "docs",
    "model",
    "benchmarks",
    "frontend",
    "graalvm-js",
    "graalvm-react",
    "test",
  )

  /** All library modules which are published. */
  public val publishedModules: List<String> = listOf(
    // Library Packages
    "base",
    "core",
    "frontend",
    "graalvm",
    "graalvm-js",
    "graalvm-jvm",
    "graalvm-kt",
    "graalvm-llvm",
    "graalvm-py",
    "graalvm-rb",
    "graalvm-react",
    "http",
    "model",
    "proto:proto-core",
    "proto:proto-capnp",
    "proto:proto-kotlinx",
    "proto:proto-protobuf",
    "rpc",
    "server",
    "serverless",
    "ssr",
    "test",
    "runtime",
  ).map { ":packages:$it" }.plus(
    listOf(
      // Tools
      "processor",
    ).map { ":tools:$it" },
  )

  /** All subproject modules which are published. */
  public val publishedSubprojects: List<String> = emptyList()

  /** All publishable targets. */
  public val allPublishTargets: List<String> = publishedModules.plus(
    publishedSubprojects,
  )
}
