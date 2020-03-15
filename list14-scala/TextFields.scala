import scala.swing._
import scala.swing.event._

object TextFields extends SimpleSwingApplication {

  def top: Frame = new MainFrame {
    title = "Text Fields"
    preferredSize = new java.awt.Dimension(350, 200)

  }

}