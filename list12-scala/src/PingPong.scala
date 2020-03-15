//import scala.actors.Actor
//
//case class Ball(from: Actor)
//
//object PingPong {
//
//  def aktor(msg: String) = actor {
//
//    var max = 5
//    loopWhile (max > 0) {
//      react {
//        case Ball(f) => {
//          max -= 1
//          println(msg)
//        }
//      }
//    }
//
//    def main(args: Array[String]): Unit = {
//      val ping = aktor("ping")
//      val pong = aktor("pong")
//
//      ping ! Ball(pong)
//    }
//
//  }
//
//}



