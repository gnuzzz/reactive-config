package com.github.fit51.reactiveconfig.javadsl

import java.nio.file.Path

import com.github.fit51.reactiveconfig.parser.CirceConfigParser
import com.github.fit51.reactiveconfig.storage.ConfigStorage
import com.github.fit51.reactiveconfig.typesafe.TypesafeConfigStorage
import io.circe.Json
import monix.eval.Task
import monix.execution.Scheduler
import CirceConfigParser._

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
object Adapter {

//  implicit val scheduler: Scheduler = monix.execution.Scheduler.global

  def typesafeConfigStorage(path: Path): ConfigStorage[Task, Json] = {
    TypesafeConfigStorage[Task, Json](path)(null, null, null, null)
  }

}
