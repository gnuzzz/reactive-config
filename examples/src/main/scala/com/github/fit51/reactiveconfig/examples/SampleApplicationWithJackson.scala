package com.github.fit51.reactiveconfig.examples

import java.nio.file.Paths

import cats.effect.Sync
import com.fasterxml.jackson.databind.JsonNode
import com.github.fit51.reactiveconfig.config.ReactiveConfig
import com.typesafe.scalalogging.LazyLogging
import monix.eval.Task
import monix.execution.Cancelable
import com.github.fit51.reactiveconfig.config._
import com.github.fit51.reactiveconfig.parser._
import com.github.fit51.reactiveconfig.typesafe.TypesafeConfigStorage

import scala.concurrent.Await
import scala.concurrent.duration._

/**
 * @author Vladimir Kornyshev {@literal <vkornyshev@at-consulting.ru>}
 */
object SampleApplicationWithJackson extends App with LazyLogging {
  implicit val scheduler = monix.execution.Scheduler.global

  import JacksonConfigParser._
  import JacksonConfigDecoder._

  def useConfig(config: ReactiveConfig[Task, JsonNode]): Task[Cancelable] = {
//    val some      = config.reloadable[String]("complex-app.something")(JacksonConfigDecoder.decoder(classOf[String]))
    implicit val stringClass: Class[String] = classOf[String]
    val some      = config.reloadable[String]("complex-app.something")
//    val libConfig = config.reloadable[SimpleLib]("complex-app.simple-lib-context.simple-lib")(JacksonConfigDecoder.decoder(classOf[SimpleLib]))
    implicit val libConfigClass: Class[SimpleLib] = classOf[SimpleLib]
    val libConfig = config.reloadable[SimpleLib]("complex-app.simple-lib-context.simple-lib")
    val combined  = libConfig.combine(some)((l, s) => l.copy(foo = s))

    Task.eval {
      println("Entered")
      scheduler.scheduleWithFixedDelay(0 seconds, 1 second) {
        println(s"some: ${some.get}")
        println(s"lib: ${libConfig.get}")
        println(s"all together: ${combined.get}")
      }
    }
  }

//  val app = for {
//    storage     <- Task.eval(TypesafeConfigStorage[Task, JsonNode](Paths.get("examples/config/application.conf")))
//    config      <- ReactiveConfigImpl[Task, JsonNode](storage)
//    _           <- Task.eval(println("Now change examples/config/application.conf file and see what happens!"))
//    cancellable <- useConfig(config)
//    _           <- Task.sleep(1.minute)
//    _           <- Task.eval(cancellable.cancel())
//  } yield ()

  val app = Task.eval(TypesafeConfigStorage[Task, JsonNode](Paths.get("examples/config/application.conf")))
      .flatMap(storage => ReactiveConfigImpl[Task, JsonNode](storage))
      .flatMap(config => Task.eval(println("Now change examples/config/application.conf file and see what happens!"))
      .flatMap(_ => useConfig(config))
      .flatMap(cancellable => Task.sleep(1.minute)
      .flatMap(_ => Task.eval(cancellable.cancel()))))

  Await.result(
    app.doOnFinish {
      case Some(e) => Task.eval(println("Error", e))
      case None    => Task.eval(println("Finished"))
    }.runToFuture,
    Duration.Inf
  )

}
