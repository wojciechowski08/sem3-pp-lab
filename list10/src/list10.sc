//1. Klasa GenericCellImm kompiluje się jako klasa inwariantna i kowariantna.
class GenericCellImm[T] (val x: T) {
}

class GenericCellImm1[+T] (val x: T) {
}

//Natomiast klasa GenericCellMut kompiluje się tylko jako klasa inwariantna.
class GenericCellMut[T] (var x: T) {
}

//Wersja kowariantna powoduje błąd kompilacji.
class GenericCellMut1[+T] (var x: T) {
} //On line 2: error: COvariant type T occurs in CONTRAvariant position in type T of value x_=

// a) Wyjaśnij powód tego błędu.

// b) Czy można się pozbyć tego błędu? Uzasadnij swoją odpowiedź.

// c) Czy wersja kontrawariantna skompiluje się? Uzasadnij swoją odpowiedź.
class GenericCellMut2[-T] (var x: T) {
} //On line 2: error: CONTRAvariant type T occurs in COvariant position in type => T of variable x


//2. Poniższa definicja powoduje błąd kompilacji.
abstract class Sequence[+A] {
  def append(x: Sequence[A]): Sequence[A]
} //On line 3: error: COvariant type A occurs in CONTRAvariant position in type Sequence[A] of value x
//Wyjaśnij przyczynę tego błędu. Czy można się go pozbyć?.




////
//// LIST 10 PROBLEM 3
////
//
//class UnderflowException(msg: String) extends Exception(msg)
//
//class MyQueue[+T] private(private val queue: (List[T], List[T])) {
//  def enqueue[S >: T](element: S): MyQueue[S] = {
//    val (beginningOfQueue, endOfQueue) = queue
//    normalize(beginningOfQueue, element :: endOfQueue)
//  }
//
//  private def normalize[S >: T](list1: List[S], list2: List[S]) =
//    (list1, list2) match {
//      case (Nil, endOfQueue) => new MyQueue[S]((endOfQueue.reverse, Nil))
//      case normalQueue => new MyQueue(normalQueue)
//    }
//
//  def dequeue: MyQueue[T] =
//    queue match {
//      case (_ :: tail, endOfQueue) => normalize(tail, endOfQueue)
//      case _ => MyQueue.empty
//    }
//
//  def first: T =
//    queue._1 match {
//      case (head :: _) => head
//      case _ => throw new UnderflowException("first")
//    }
//
//  def isEmpty: Boolean =
//    queue._1 == Nil
//
//  //only for tests
//  override def equals(obj: Any): Boolean =
//    obj match {
//      case obj: MyQueue[_] => queue._1 ++ queue._2.reverse == obj.queue._1 ++ obj.queue._2.reverse
//      case _ => false
//    }
//}
//
//object MyQueue {
//  def apply[T](xs: T*) = new MyQueue[T](xs.toList, Nil)
//
//  def empty[T] = new MyQueue[T](Nil, Nil)
//}
//
//
//
////
//// LIST 10 PROBLEM 4 SCALA
////
//
//import scala.collection.mutable
//
//def copy[T] (dest: mutable.Seq[T], src :mutable.Seq[T]) : Unit = {
//  require(dest.length >= src.length)
//  var index = 0
//  src.foreach(element => {
//    dest.update(index, element)
//    index += 1
//  })
//}
//
//// (ArrayBuffer)