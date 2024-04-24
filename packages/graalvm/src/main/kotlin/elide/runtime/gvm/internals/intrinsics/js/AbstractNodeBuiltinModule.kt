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
package elide.runtime.gvm.internals.intrinsics.js

import elide.runtime.intrinsics.GuestIntrinsic.MutableIntrinsicBindings

/** Abstract base for all built-in Node API modules. */
internal abstract class AbstractNodeBuiltinModule : AbstractJsIntrinsic() {
  override fun install(bindings: MutableIntrinsicBindings) {
    // nothing to install: modules are not globalized by default
  }
}
