package elide.runtime.gvm.internals

import org.junit.jupiter.api.Assertions.*
import elide.runtime.gvm.internals.intrinsics.js.JsSymbol
import elide.runtime.intrinsics.GuestIntrinsic
import elide.runtime.intrinsics.GuestIntrinsic.MutableIntrinsicBindings
import elide.testing.annotations.Test

/** Abstract base for intrinsic-bound tests. */
internal abstract class AbstractIntrinsicTest<T : GuestIntrinsic> : AbstractDualTest() {
  /** @return Intrinsic implementation under test. */
  protected abstract fun provide(): T

  /** Test injection of an intrinsic implementation. */
  @Test abstract fun testInjectable()

  /** Test installation of the intrinsic. */
  @Test fun testInstall() {
    val target = HashMap<JsSymbol, Any>()
    val subject = provide()
    assertNotNull(subject, "should not get `null` subject from `provide` for intrinsic under test")
    assertDoesNotThrow {
      subject.install(MutableIntrinsicBindings.Factory.wrap(target))
    }
    assertTrue(target.isNotEmpty(), "should have at least one intrinsic binding installed")
  }
}
