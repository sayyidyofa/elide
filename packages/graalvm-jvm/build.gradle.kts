/*
 * Copyright (c) 2024 Elide Technologies, Inc.
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

import elide.internal.conventions.kotlin.KotlinTarget
import elide.internal.conventions.native.NativeTarget
import elide.internal.conventions.publishing.publish

plugins {
  alias(libs.plugins.micronaut.library)
  alias(libs.plugins.micronaut.graalvm)

  kotlin("jvm")
  kotlin("kapt")
  kotlin("plugin.allopen")

  id("elide.internal.conventions")
}

elide {
  publishing {
    id = "graalvm-jvm"
    name = "Elide JVM integration package for GraalVM"
    description = "Integration package with GraalVM, Elide, and JVM."

    publish("jvm") {
      from(components["kotlin"])
    }
  }

  kotlin {
    target = KotlinTarget.JVM
    explicitApi = true
  }

  java {
    // disable module-info processing (not present)
    configureModularity = false
  }

  native {
    target = NativeTarget.LIB
  }
}

dependencies {
  api(libs.graalvm.polyglot.java)
  implementation(libs.kotlinx.coroutines.core)
  implementation(projects.packages.graalvm)
  implementation(libs.graalvm.espresso.hotswap)
  implementation(libs.graalvm.espresso.language)
  compileOnly(libs.graalvm.espresso.polyglot)

  // Testing
  testImplementation(projects.packages.test)
}
