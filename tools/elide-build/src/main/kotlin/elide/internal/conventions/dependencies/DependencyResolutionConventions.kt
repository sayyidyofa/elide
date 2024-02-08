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

package elide.internal.conventions.dependencies

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.LockMode
import org.gradle.kotlin.dsl.exclude
import elide.internal.conventions.Constants.Versions
import elide.internal.conventions.ElideBuildExtension

private val nettyExemptions = sortedSetOf(
  "epoll",
  "kqueue",
  "tcnative",
  "boringssl",
)

/** Introduces dependency locking settings. */
internal fun Project.configureDependencyLocking(conventions: ElideBuildExtension) {
  if (conventions.deps.locking) {
    // configure dependency locking
    dependencyLocking {
      lockMode.set(LockMode.LENIENT)
      ignoredDependencies.addAll(
        listOf(
          "org.jetbrains.kotlinx:atomicfu*",
          "org.jetbrains.kotlinx:kotlinx-serialization*",
        ),
      )
    }
  }

  tasks.register("resolveAndLockAll") {
    doFirst {
      require(gradle.startParameter.isWriteDependencyLocks)
    }

    doLast {
      // resolve all possible configurations
      configurations.filter {
        it.isCanBeResolved && !it.name.lowercase().let { name ->
          name.contains("sources") || name.contains("documentation")
        }
      }.forEach { it.resolve() }
    }
  }
}

/** Establishes the dependency conflict resolution policy. */
internal fun Project.configureDependencyResolution(conventions: ElideBuildExtension) {
  configurations.all {
    resolutionStrategy.apply {
      // prefer modules that are part of this build
      preferProjectModules()

      if (conventions.deps.strict) {
        // fail eagerly on version conflict (includes transitive dependencies)
        failOnVersionConflict()
      }
    }

    resolutionStrategy.eachDependency {
      // process dependency pins: kotlin
      if (requested.group == "org.jetbrains.kotlin" && requested.name.contains("stdlib")) {
        useVersion(Versions.KOTLIN_SDK_PIN)
        because("pin kotlin stdlib")
      }

      // process dependency pins: netty
      if (requested.group == "io.netty" && !nettyExemptions.any { requested.name.contains(it) }) {
        useVersion(Versions.NETTY)
        because("pin netty")
      }

      // process dependency pins: guava
      if (requested.group == "com.google.guava" && requested.name.contains("guava")) {
        useVersion(Versions.GUAVA)
        because("pin guava")
      }

      // process dependency pins: grpc
      if (requested.group == "io.grpc" && !requested.name.contains("kotlin")) {
        useVersion(Versions.GRPC)
        because("pin grpc")
      }
    }
  }
}
