package com.github.fit51.reactiveconfig.javadsl.reloadable

import java.util.function.BiFunction

import com.github.fit51.reactiveconfig

/**
 * Java DSL wrapper implementation for [[Reloadable]]
 */
//class ReloadableImpl[F[_], V](val wrapped: reactiveconfig.reloadable.Reloadable[F, _, V])(implicit mapper: Map[F]) extends Reloadable[F, V] {
class ReloadableImpl[F[_], V](val wrapped: reactiveconfig.reloadable.Reloadable[F, _, V])(implicit mapper: MapFunction[F[_], Function[_, _], F[_]]) extends Reloadable[F, V] {

  override def get: V = wrapped.get

  override def map[NEW_V](f: V => NEW_V, behaviour: ReloadBehaviour[F, V, NEW_V]): Reloadable[F, NEW_V] =
    new ReloadableImpl[F, NEW_V](wrapped.map(f, behaviour.wrapped))

  override def map[NEW_V](f: V => NEW_V): Reloadable[F, NEW_V] = new ReloadableImpl[F, NEW_V](wrapped.map(f))

  override def flatMap[NEW_V](f: V => F[NEW_V], behaviour: ReloadBehaviour[F, V, NEW_V]): F[Reloadable[F, NEW_V]] = {
    val taskMapFunction: java.util.function.Function[reactiveconfig.reloadable.Reloadable[F, V, NEW_V], Reloadable[F, NEW_V]] = r => new ReloadableImpl[F, NEW_V](r)
    mapper.apply(
      wrapped.mapF(f, behaviour.wrapped), taskMapFunction.asInstanceOf
    ).asInstanceOf
  }

  override def flatMap[NEW_V](f: V => F[NEW_V]): F[Reloadable[F, NEW_V]] = {
    val taskMapFunction: java.util.function.Function[reactiveconfig.reloadable.Reloadable[F, V, NEW_V], Reloadable[F, NEW_V]] = r => new ReloadableImpl[F, NEW_V](r)
    mapper.apply(
      wrapped.mapF(f), taskMapFunction.asInstanceOf
    ).asInstanceOf
  }

  override def combine[OTHER_V, COMBINED_V](other: Reloadable[F, OTHER_V], f: (V, OTHER_V) => COMBINED_V, reloadBehaviour: ReloadBehaviour[F, (V, OTHER_V), COMBINED_V]): Reloadable[F, COMBINED_V] =
    new ReloadableImpl[F, COMBINED_V](wrapped.combine(other.wrapped)(f, reloadBehaviour.wrapped))

  override def combine[OTHER_V, COMBINED_V](other: Reloadable[F, OTHER_V], f: (V, OTHER_V) => COMBINED_V): Reloadable[F, COMBINED_V] =
    new ReloadableImpl[F, COMBINED_V](wrapped.combine(other.wrapped)(f))

  override def compose[OTHER_V, COMPOSED_V](other: Reloadable[F, OTHER_V], f: (V, OTHER_V) => F[COMPOSED_V], reloadBehaviour: ReloadBehaviour[F, (V, OTHER_V), COMPOSED_V]): F[Reloadable[F, COMPOSED_V]] = ???
//    mapper.map[reactiveconfig.reloadable.Reloadable[F, (V, OTHER_V), COMPOSED_V], Reloadable[F, COMPOSED_V]](
//      wrapped.combineF(other.wrapped)(f, reloadBehaviour.wrapped), r => new ReloadableImpl[F, COMPOSED_V](r)
//    )

  override def compose[OTHER_V, COMPOSED_V](other: Reloadable[F, OTHER_V], f: (V, OTHER_V) => F[COMPOSED_V]): F[Reloadable[F, COMPOSED_V]] = ???
//    mapper.map[reactiveconfig.reloadable.Reloadable[F, (V, OTHER_V), COMPOSED_V], Reloadable[F, COMPOSED_V]](
//      wrapped.combineF(other.wrapped)(f), r => new ReloadableImpl[F, COMPOSED_V](r)
//    )
}
