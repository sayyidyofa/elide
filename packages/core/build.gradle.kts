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

import elide.internal.conventions.kotlin.*

plugins {
  id("elide.internal.conventions")
  kotlin("multiplatform")
  kotlin("plugin.atomicfu")
  kotlin("plugin.serialization")
}

elide {
  publishing {
    id = "core"
    name = "Elide Core"
    description = "Pure Kotlin utilities provided across all supported platforms for the Elide Framework."
  }

  kotlin {
    atomicFu = true
    target = KotlinTarget.All
    explicitApi = true
  }
}

dependencies {
  common {
    implementation(libs.kotlinx.atomicfu)
  }

  jvm {
    api(kotlin("stdlib-jdk8"))
    api(libs.jetbrains.annotations)
  }
}

tasks {
  withType<org.jetbrains.dokka.gradle.DokkaTaskPartial>().configureEach {
    dokkaSourceSets {
      configureEach {
        includes.from("module.md")
      }
    }
  }
}
