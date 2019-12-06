package com.github.fit51.reactiveconfig.javadsl.reloadable

import com.github.fit51.reactiveconfig.reloadable

/**
  * Reload policy
  *
  * @see [[Reloadable]]
  */
trait ReloadBehaviour[F[_], A, B] {

  val wrapped: reloadable.ReloadBehaviour[F, A, B]

  /**
    * @return reload function: given updated input [[A]] and current output [[B]] returns new output instance [[B]]
    */
  def reload(): (A, B) => F[B]

}

/**
  * Most common reload policy
  *
  * When new [[A]] arrives - creates new [[B]]
  */
case class Simple[F[_], A, B](start: A => F[B]) extends ReloadBehaviour[F, A, B] {

  override val wrapped: reloadable.Simple[F, A, B] = new reloadable.Simple[F, A, B]

  override def reload(): (A, B) => F[B] =
    wrapped.reload(start)
}

/**
  * Stop reload policy
  *
  * When new [[A]] arrives - creates a new [[B]] and then stops current [[B]]
  * @param stop Stop function
  */
case class Stop[F[_] : cats.FlatMap, A, B](start: A => F[B], stop: B => F[_]) extends ReloadBehaviour[F, A, B] {

  override val wrapped: reloadable.Stop[F, A, B] = new reloadable.Stop[F, A, B](stop)

  override def reload(): (A, B) => F[B] =
    wrapped.reload(start)
}

/**
  * Restart reload policy
  *
  * When new [[A]] arrives - restarts current B instance with [[restart]]
  * @param restart shows how to restart current instance[[B]] with new input [[A]]
  * Note: Use this in cases, when [[B]] supports restart.
  */
case class Restart[F[_], A, B](restart: (A, B) => F[B]) extends ReloadBehaviour[F, A, B] {

  override val wrapped: reloadable.Restart[F, A, B] = new reloadable.Restart[F, A, B](restart)

  override def reload(): (A, B) => F[B] =
    wrapped.reload(null)
}
