package elide.runtime.plugins.java.shell

import jdk.jshell.spi.ExecutionControl
import jdk.jshell.spi.ExecutionControl.ClassBytecodes
import jdk.jshell.spi.ExecutionControl.NotImplementedException
import org.graalvm.polyglot.PolyglotException
import elide.runtime.core.DelicateElideApi
import elide.runtime.core.PolyglotValue
import elide.runtime.plugins.jvm.interop.asStringOrNull

@DelicateElideApi internal class GuestExecutionControl(
  private val guestDelegate: PolyglotValue,
  private val exceptionMapper: GuestExceptionMapper,
  private val bytecodeMapper: GuestBytecodeMapper,
) : ExecutionControl {
  private fun tryInvoke(method: String, vararg args: Any?): PolyglotValue = try {
    // use the guest-side execution control
    guestDelegate.invokeMember(method, *args)
  } catch (error: PolyglotException) {
    // map to a host exception and re-throw
    throw exceptionMapper.map(error)
  }

  override fun close() {
    tryInvoke("close")
  }

  override fun load(cbcs: Array<out ClassBytecodes>) {
    tryInvoke("load", bytecodeMapper.map(cbcs))
  }

  override fun redefine(cbcs: Array<out ClassBytecodes>) {
    tryInvoke("redefine", bytecodeMapper.map(cbcs))
  }

  override fun invoke(className: String?, methodName: String?): String? {
    return tryInvoke("invoke", className, methodName).asStringOrNull()
  }

  override fun varValue(className: String?, varName: String?): String? {
    return tryInvoke("varValue", className, varName).asStringOrNull()
  }

  override fun addToClasspath(path: String?) {
    tryInvoke("addToClasspath", path)
  }

  override fun stop() {
    tryInvoke("stop")
  }

  override fun extensionCommand(command: String?, arg: Any?): Any {
    throw NotImplementedException("extensionCommand: $command")
  }
}