package com.github.fit51.reactiveconfig.javadsl.config

import java.util.Optional

import com.github.fit51.reactiveconfig
import com.github.fit51.reactiveconfig.javadsl.ReactiveConfigException
import com.github.fit51.reactiveconfig.parser.ConfigDecoder
import com.github.fit51.reactiveconfig.reloadable.Reloadable

class ReactiveConfig[F[_]](private val config: reactiveconfig.config.ReactiveConfig[F, _]) {

  def get[T](key: String)(implicit decoder: ConfigDecoder[T, _]): Optional[T] = {
//    config.get(key) match {
//      case Some(value) => Optional.of(value)
//      case None => Optional.empty()
//    }
    null
  }

//  @throws(classOf[ReactiveConfigException])
//  def getOrThrow[T](key: String)(implicit decoder: ConfigDecoder[T, _]): T = config.getOrThrow(key)
//
//  def reloadable[T](key: String)(implicit decoder: ConfigDecoder[T, _]): Reloadable[F, T, T] = config.reloadable(key)
}
