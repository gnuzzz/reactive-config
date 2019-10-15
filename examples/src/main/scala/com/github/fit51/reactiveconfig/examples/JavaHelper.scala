package com.github.fit51.reactiveconfig.examples

import java.nio.file.{Path, Paths}

import com.fasterxml.jackson.databind.JsonNode
import com.github.fit51.reactiveconfig.parser.JacksonConfigParser
import com.github.fit51.reactiveconfig.storage.ConfigStorage
import com.github.fit51.reactiveconfig.typesafe.TypesafeConfigStorage
import monix.eval.Task
import monix.execution.Scheduler
import JacksonConfigParser._
import com.github.fit51.reactiveconfig.config.{ReactiveConfig, ReactiveConfigImpl}

/**
  * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
  */
object JavaHelper {

  implicit val scheduler: Scheduler = monix.execution.Scheduler.global

  def defaultScheduler(): Scheduler = scheduler

  def typesafeConfigStorage(path: Path): ConfigStorage[Task, JsonNode] = {
    TypesafeConfigStorage[Task, JsonNode](path)
  }

  def reactiveConfig(storage: ConfigStorage[Task, JsonNode]): Task[ReactiveConfig[Task, JsonNode]] = {
    Tuple3
    ReactiveConfigImpl[Task, JsonNode](storage)
  }

}
