import akka.actor.{ActorSystem, Props}

case class Moves(movesLeft: Int)
case class Start(moves: Int, player: ActorRef)

object Match {

  class Player(private val name: String, private val msg: String) extends Aktor {

    override def receive: Receive = {

      case Moves(moves) => {
        if (moves > 0) {
          println(name + ": " + msg)
          sender() ! Moves(moves - 1)
        } else {
          context.system.terminate()
        }
      }
      case Start(moves, player) => {
        if (moves > 0) {
          println(name + ": " + msg)
          player ! Moves(moves - 1)
        } else {
          println("\n***Number of moves is smaller than 1!***")
          context.system.terminate()
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {

    val myMatch = ActorSystem("MyMatch")
    val p1 = myMatch.actorOf(Props(new Player("Piotr", "Ping")))
    val p2 = myMatch.actorOf(Props(new Player("Pavel", "Pong")))

    p1 ! Start(5, p2)
  }

}