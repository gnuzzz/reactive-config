package com.github.fit51.reactiveconfig.javadsl.reloadable

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
trait Map[F[_]] {
  def map[V, NEW_V](f: F[V], mapFunction: V => NEW_V): F[NEW_V]
}
