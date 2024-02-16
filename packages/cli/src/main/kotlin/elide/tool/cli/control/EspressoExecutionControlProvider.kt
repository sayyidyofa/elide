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

package elide.tool.cli.control

import jdk.jshell.spi.ExecutionControl
import jdk.jshell.spi.ExecutionControlProvider
import jdk.jshell.spi.ExecutionEnv

/**
 * # Execution Control
 *
 * Installed as the execution control provider for an Espresso-based JShell.
 */
class EspressoExecutionControlProvider: ExecutionControlProvider {
  override fun name(): String {
    TODO("Not yet implemented")
  }

  override fun generate(env: ExecutionEnv?, parameters: MutableMap<String, String>?): ExecutionControl {
    TODO("Not yet implemented")
  }
}
