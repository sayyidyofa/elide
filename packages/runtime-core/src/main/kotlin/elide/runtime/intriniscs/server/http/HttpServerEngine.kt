package elide.runtime.intriniscs.server.http

import org.graalvm.polyglot.HostAccess.Export
import elide.runtime.core.DelicateElideApi

/**
 * A base contract for HTTP server implementations that must be configurable by guest code.
 *
 * The [config] property allows guest code to change the binding port, set a start callback, and adjust other
 * backend-specific options as applicable.
 *
 * The [router] property can be used to register route handlers from guest code.
 *
 * Note that [start] is intentionally not exported to guest code, as it is intended for use by the [HttpServerAgent].
 */
@DelicateElideApi public interface HttpServerEngine {
  /** Router for this server engine, accessible by guest code and capable of registering route handlers. */
  @get:Export public val router: HttpRouter

  /** Configuration for this server engine, accessible by guest code. */
  @get:Export public val config: HttpServerConfig

  /** Starts the server backend. */
  public fun start()
}