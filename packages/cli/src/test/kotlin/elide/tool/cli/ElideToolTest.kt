package elide.tool.cli

import kotlin.test.assertNotNull
import elide.annotations.Inject
import elide.testing.annotations.Test
import elide.testing.annotations.TestCase

/** Tests for the main CLI tool entrypoint. */
@TestCase class ElideToolTest {
  @Inject lateinit var tool: ElideTool

  @Test fun testEntrypoint() {
    assertNotNull(tool, "should be able to init and inject entrypoint")
  }
}
