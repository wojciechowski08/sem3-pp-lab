import akka.actor.Actor

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