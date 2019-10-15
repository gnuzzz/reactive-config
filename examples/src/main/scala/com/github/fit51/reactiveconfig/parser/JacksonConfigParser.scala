package com.github.fit51.reactiveconfig.parser

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.github.fit51.reactiveconfig.ReactiveConfigException
import com.typesafe.scalalogging.StrictLogging

import scala.util.{Failure, Success, Try}

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
object JacksonConfigParser {
  implicit lazy val parser: ConfigParser[JsonNode] = new JacksonConfigParser
}

class JacksonConfigParser extends ConfigParser[JsonNode] with StrictLogging {
  override def parse(rawData: String): Try[JsonNode] = {
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    try {
      Success(mapper.readTree(rawData))
    } catch {
      case e: Exception =>
        logger.error(s"Unable to parse json from String: $rawData", e)
        Failure(ReactiveConfigException(e.getMessage))
    }
  }

}
