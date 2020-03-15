sealed trait Figure[+A]
case class Square[+A] (side:A) extends Figure[A]
case class Circle[+A] (radius:A) extends Figure[A]
case class Triangle[+A] (base:A, height:A) extends Figure[A]

val s = Square(4)
val ss = Square(4)
val c = Circle(10)
val t = Triangle(5, 4)

