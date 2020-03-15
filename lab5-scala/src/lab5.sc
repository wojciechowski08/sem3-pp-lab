def lDzialanie[A](st1: Stream[A], st2: Stream[A])(f: A => A => A): Stream[A] = {
  (st1, st2) match {
    case (Stream.Empty, Stream.Empty) => Stream.empty
    case (Stream.Empty, hd2 #:: tl2) => hd2 #:: lDzialanie(Stream.Empty, tl2)(f)
    case (hd1 #:: tl1, Stream.Empty) => hd1 #:: lDzialanie(tl1, Stream.Empty)(f)
    case (hd1 #:: tl1, hd2 #:: tl2) => f(hd1)(hd2) #:: lDzialanie(tl1, tl2)(f)
  }
}

val st1 = 2 #:: 5 #:: 9 #:: Stream.empty[Int]

val st2 = 21 #:: 2 #:: 7 #:: 15 #:: 10 #:: Stream.empty[Int]

def product (x: Int)(y: Int) = x * y

lDzialanie(st1, st2)((x: Int) => (y: Int) => x * y).force

lDzialanie(Stream.from(5).take(9), Stream.from(2).take(4))(product).force


//def lDzialanie[A](st1: LazyList[A], st2: LazyList[A])(f: A => A => A): LazyList[A] = {
//  (st1, st2) match {
//    case (LazyList (), LazyList ()) => LazyList ()
//    case (LazyList (), hd2 #:: tl2) => hd2 #:: lDzialanie(LazyList (), tl2)(f)
//    case (hd1 #:: tl1, LazyList ()) => hd1 #:: lDzialanie(tl1, LazyList ())(f)
//    case (hd1 #:: tl1, hd2 #:: tl2) => f(hd1)(hd2) #:: lDzialanie(tl1, tl2)(f)
//  }
//}
//
//val st1 = 2 #:: 5 #:: 9 #:: LazyList ()[Int]
//
//val st2 = 21 #:: 2 #:: 7 #:: 15 #:: 10 #:: LazyList ()[Int]
//
//def product (x: Int)(y: Int) = x * y
//
//lDzialanie(st1, st2)((x: Int) => (y: Int) => x * y).force
//
//lDzialanie(LazyList.from(5).take(9), LazyList.from(2).take(4))(product).force