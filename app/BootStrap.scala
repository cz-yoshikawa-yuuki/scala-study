import adapter.http.system.controller.DebugController
import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

object BootStrap extends App {
  implicit lazy val system = ActorSystem("my-system")
  implicit lazy val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher
  val interface = "localhost"
  val port = 8080
  val logger = Logging(system, getClass)

  val test = new DebugController()
  val routes = test.route

  val binding = Http().bindAndHandle(routes, interface, port)
}