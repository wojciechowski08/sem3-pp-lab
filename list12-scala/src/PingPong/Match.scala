import akka.actor.{ActorSystem, Props}

object Match {

  def main(args: Array[String]): Unit = {

    val myMatch = ActorSystem("MyMatch")
    val p1 = myMatch.actorOf(Props(new Player("Piotr", "Ping")))
    val p2 = myMatch.actorOf(Props(new Player("Pavel", "Pong")))

    p1 ! Start(5, p2)
  }

}