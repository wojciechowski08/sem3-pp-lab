class Point(protected var xp: Double =0, protected var yp: Double =0) {
  def x: Double = xp
  def y: Double = yp
  def x_= (value: Double) = {xp = value; this}
  def y_= (value: Double) = {yp = value; this}
  override def toString: String = s"($xp, $yp)"
}
class Circle(xp: Double =0, yp: Double =0, protected var rc: Double =1) extends Point(xp,yp) {
  def r: Double = rc
  def r_= (value: Double) = {rc = value; this}
  override def toString: String = super.toString + " r = " + rc
}