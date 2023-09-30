package elide.runtime.core

/** Provides information about the runtime hosting the application. */
@DelicateElideApi public interface HostRuntime {
  /** The name of this runtime, which is used in string representations and for debugging purposes. */
  public val name: String

  /** The version spec of this runtime, wrapped to allow version comparisons using regular operators. */
  public val version: Version?

  /**
   * An optional variant name for this runtime. Some engines like GraalVM differentiate between runtime variants
   * depending on the packaging of the applic`2ation.
   */
  public val variant: String?
}

/**
 * Execute a [block] and return its result if this runtime's is running the provided [version], otherwise return
 * `null`. If this runtime's version can't be detected, `null` will be returned. 
 */
@DelicateElideApi public inline fun <R> HostRuntime.on(version: Version, block: () -> R): R? {
  return if (this.version == version) block() else null
}

/**
 * Execute a [block] and return its result if this runtime's version is in the provided [range], otherwise return
 * `null`. If this runtime's version can't be detected, `null` will be returned.
 */
@DelicateElideApi public inline fun <R> HostRuntime.on(range: Version.Range, block: () -> R): R? {
  return version?.takeIf { it in range }?.let { block() }
}