//
// LIST 9 PROBLEM 1 SCALA
//

// a)

class Time(private var h :Int) {
  if (h < 0) h = 0
  def hour :Int = h
  def hour_= (newHour :Int) {
    if (newHour < 0) h = 0
    else h = newHour
  }
}




// b)

object Time {
  def apply(hour :Int) = new Time(hour)
}
var t = new Time(24)
t.hour
t.hour = 23
t.hour
var tt = Time.apply(22)
tt.hour

//
// LIST 9 PROBLEM 2 SCALA
//

// a)

class Time2 (private var h :Int, private var m :Int) {
  require( h >= 0 && h < 24)
  require( m >= 0 && m < 60)

  def hour :Int = h
  def hour_= (newHour :Int) {
    require( newHour >= 0 && newHour < 24)
    h = newHour
  }
  def minute: Int = m

  def minute_=(newMinute: Int) {
    require(0 <= newMinute && newMinute < 60)
    m = newMinute
  }

  def before(other :Time2) : Boolean =
    h < other.h || h == other.h && m < other.m

}

// b)

class Time3 (private var h :Int, private var m :Int) {
  require( h >= 0 && h < 24)
  require( m >= 0 && m < 60)
  private var minutesAfterMidnight = h * 60 + m

  def hour :Int = h
  def hour_= (newHour :Int) {
    require( newHour >= 0 && newHour < 24)
//    h = newHour
    minutesAfterMidnight = minute + newHour * 60
  }
  def minute: Int = m
  def minute_=(newMinute: Int) {
    require(0 <= newMinute && newMinute < 60)
//    m = newMinute
    minutesAfterMidnight = hour + newMinute
  }
//  def minutesAfterMidnight :Int = {}

  def before(other :Time3) : Boolean = {
//    h < other.h || h == other.h && m < other.m
    minutesAfterMidnight < other.minutesAfterMidnight
  }
}



//
// LIST 9 PROBLEM 2 SCALA
//

class Vehicle(val brand :String, val model :String, val year :Int = -1, var rNumber :String = "") {

  def this(brand:String, model:String, rNumber:String) {
    this(brand, model, -1, rNumber)
  }

}

new Vehicle("Lambo", "Aventador", 2015, "ESSA69")
new Vehicle("Lambo", "Aventador", 2015)
new Vehicle("Lambo", "Aventador", "ESSA69")
new Vehicle("Lambo", "Aventador")

//
// LIST 9 PROBLEM 4 SCALA
//

// Demonstracja wykorzystania metod getMessage i printStackTrace,
// dziedziczonych przez wszystkie klasy wyjatkow.
//object UzycieWyjatkow {
//  def main(args: Array[String]): Unit = {
//    try metoda1()
//    catch {
//      case e: Exception =>
//        System.err.println(e.getMessage + "\n")
//        e.printStackTrace()
//    }
//  }
//
//  @throws[Exception]
//  def metoda1(): Unit = {
//    metoda2()
//  }
//
//  @throws[Exception]
//  def metoda2(): Unit = {
//    metoda3()
//  }
//
//  @throws[Exception]
//  def metoda3(): Unit = {
//    throw new Exception("Wyjatek zgloszony w metoda3")
//  }
//}