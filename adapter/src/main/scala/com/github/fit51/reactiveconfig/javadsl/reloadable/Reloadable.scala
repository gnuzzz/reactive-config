package com.github.fit51.reactiveconfig.javadsl.reloadable

import com.github.fit51.reactiveconfig

/**
  * Java DSL wrapper for [[reactiveconfig.reloadable.Reloadable]]
  *
  * @tparam F [_] reloading effect
  * @tparam V wrapped value
 */
trait Reloadable[F[_], V] {

  val wrapped: reactiveconfig.reloadable.Reloadable[F, _, V]

  def get: V

  def map[NEW_V](f: V => NEW_V, behaviour: ReloadBehaviour[F, V, NEW_V]): Reloadable[F, NEW_V]

  def map[NEW_V](f: V => NEW_V): Reloadable[F, NEW_V]

  def flatMap[NEW_V](f: V => F[NEW_V], behaviour: ReloadBehaviour[F, V, NEW_V]): F[Reloadable[F, NEW_V]]

  def flatMap[NEW_V](f: V => F[NEW_V]): F[Reloadable[F, NEW_V]]

  def combine[OTHER_V, COMBINED_V](other: Reloadable[F, OTHER_V], f: (V, OTHER_V) => COMBINED_V, reloadBehaviour: ReloadBehaviour[F, (V, OTHER_V), COMBINED_V]): Reloadable[F, COMBINED_V]

  def combine[OTHER_V, COMBINED_V](other: Reloadable[F, OTHER_V], f: (V, OTHER_V) => COMBINED_V): Reloadable[F, COMBINED_V]

  def compose[OTHER_V, COMBINED_V](other: Reloadable[F, OTHER_V], f: (V, OTHER_V) => F[COMBINED_V], reloadBehaviour: ReloadBehaviour[F, (V, OTHER_V), COMBINED_V]): F[Reloadable[F, COMBINED_V]]

  def compose[OTHER_V, COMBINED_V](other: Reloadable[F, OTHER_V], f: (V, OTHER_V) => F[COMBINED_V]): F[Reloadable[F, COMBINED_V]]

}
