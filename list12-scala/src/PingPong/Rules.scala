import akka.actor.ActorRef

case class Moves(movesLeft: Int)
case class Start(moves: Int, player: ActorRef)