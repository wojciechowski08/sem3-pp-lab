class Point(protected var xp: Double =0, protected var yp: Double =0) {
  def x: Double = xp
  def y: Double = yp
  def x_= (value: Double) = {}
  override def toString: String = s"($xp, $yp)"

}