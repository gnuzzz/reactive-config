package com.github.fit51.reactiveconfig.parser

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.github.fit51.reactiveconfig.ReactiveConfigException
import com.typesafe.scalalogging.StrictLogging

import scala.util.{Failure, Success, Try}

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
object JacksonConfigDecoder {
  implicit def decoder[T](implicit clazz: Class[T]): JacksonConfigDecoder[T] = new JacksonConfigDecoder[T]()
}

class JacksonConfigDecoder[T](implicit clazz: Class[T]) extends ConfigDecoder[T, JsonNode] with StrictLogging {
  override def decode(parsed: JsonNode): Try[T] = {
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    try {
      Success(mapper.convertValue(parsed, clazz))
    } catch {
      case e: Exception =>
        logger.error(s"Unable to decode json: $parsed", e)
        Failure(ReactiveConfigException(e.getMessage))
    }
  }
}
