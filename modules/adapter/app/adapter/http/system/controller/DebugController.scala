package adapter.http.system.controller

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import domain.system.DebugData

/**
  * DebugController.
  */
class DebugController() {

  val debugRoutes = path("") {
    get {
      complete("ok")
    }
  } ~ get {
    pathPrefix("api") {
      path("debug" / IntNumber) { num =>
        get {
          val result = DebugData(
            status = 200,
            message = s"""success! param: ${num}"""
          )
          val json = parse(result)
          complete("ok: " + json)
        }
      }
    }
  }

  def parse(input: DebugData) = {
    import io.circe.generic.auto._
    import io.circe.syntax._
    input.asJson.noSpaces
  }

  val route: Route = debugRoutes
}
