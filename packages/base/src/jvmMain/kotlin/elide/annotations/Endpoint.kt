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

package elide.annotations

import jakarta.inject.Singleton

/**
 * Marks a class as an API endpoint, which enables functionality for type conversion between [elide.model.WireMessage]
 * types and Micronaut requests / responses.
 *
 * [Endpoint] should be used in conjunction with other Micronaut annotations, like `@Controller`. Classes marked as
 * endpoints automatically participate in DI as [Singleton]s.
 */
@Singleton
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
public annotation class Endpoint
