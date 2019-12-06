package com.github.fit51.reactiveconfig.javadsl.reloadable

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
trait FlatMap[F[_]] {
  def map[V, NEW_V](f: F[V], mapFunction: V => F[NEW_V]): F[NEW_V]
}
