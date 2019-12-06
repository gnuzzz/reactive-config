package com.github.fit51.reactiveconfig.javadsl

/**
 * @author Vladimir Kornyshev
 */
class ReactiveConfigException(message: String, cause: Throwable,
                              enableSuppression: Boolean,
                              writableStackTrace: Boolean) extends Exception(message, cause, enableSuppression, writableStackTrace) {
  def this(message: String) {
    this(message, null, false, false)
  }

  def this(cause: Throwable) {
    this(null, cause, false, false)
  }

  def this(message: String, cause: Throwable) {
    this(message, cause, false, false)
  }
}
