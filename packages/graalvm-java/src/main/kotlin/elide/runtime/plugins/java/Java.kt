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

package elide.runtime.plugins.java

import elide.runtime.core.DelicateElideApi
import elide.runtime.core.EnginePlugin
import elide.runtime.core.EnginePlugin.InstallationScope
import elide.runtime.core.EnginePlugin.Key
import elide.runtime.core.getOrInstall
import elide.runtime.plugins.jvm.Jvm

@Suppress("unused") @DelicateElideApi public class Java private constructor(private val config: JavaConfig) {
  public companion object Plugin : EnginePlugin<JavaConfig, Java> {
    private const val JAVA_PLUGIN_ID = "Kotlin"
    override val key: Key<Java> = Key(JAVA_PLUGIN_ID)

    override fun install(scope: InstallationScope, configuration: JavaConfig.() -> Unit): Java {
      // apply the JVM plugin first
      scope.configuration.getOrInstall(Jvm)

      // apply the configuration and create the plugin instance
      val config = JavaConfig().apply(configuration)
      val instance = Java(config)

      return instance
    }
  }
}