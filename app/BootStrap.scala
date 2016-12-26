import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object BootStrap extends App {
  implicit lazy val system = ActorSystem("my-system")
  implicit lazy val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher
  val interface = "localhost"
  val port = 8080
  val logger = Logging(system, getClass)

  val routes = path("") {
    get {
      complete("ok")
    }
  } ~ get {
    pathPrefix("api") {
      path("execute" / IntNumber) { num =>
        get {
          complete("ok: " + num)
        }
      }
    }
  }

  val binding = Http().bindAndHandle(routes, interface, port)
}