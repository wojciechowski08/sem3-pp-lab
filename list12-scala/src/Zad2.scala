import akka.actor.{ActorRef, ActorSystem, Props}
import java.util.Random

case class Ball(count: Int = 0)

object Match {

  class Player(val name: String, players: => List[ActorRef]) extends Actor {
    private var throwsNum = 0

    override def receive: Receive = {
      case Ball(count) => {
        if (count >= 100)
          context.system.terminate()
        println(name + " throws: " + throwsNum + " Ball: " + count)
        throwsNum += 1
        this.players((new Random).nextInt(players.length)) ! Ball(count + 1)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val myMatch = ActorSystem("MyMatch")

    var players_1: List[ActorRef] = Nil
    var players_2: List[ActorRef] = Nil
    var players_3: List[ActorRef] = Nil

    val player_1 = myMatch.actorOf(Props( new Player( "Rudy", players_1)))
    val player_2 = myMatch.actorOf(Props(new Player( "Alek", players_2)))
    val player_3 = myMatch.actorOf(Props(new Player( "Zoska", players_3)))

    players_1 = List(player_2, player_3)
    players_2 = List(player_1, player_3)
    players_3 = List(player_1, player_2)

    player_1 ! Ball()

  }
}