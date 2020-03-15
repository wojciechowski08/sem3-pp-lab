import scala.swing._
import scala.swing.event._

object ButtonClicks extends SimpleSwingApplication {

  //top in SimpleSwingApplication is abstract
  def top: Frame = new MainFrame {
    title = "Button Clicks"
    preferredSize = new java.awt.Dimension(350,130)
    val button = new Button {
      text = "Click me"
      background = java.awt.Color.CYAN
      mnemonic = Key.ButtonClicks.super
      tooltip = "Short Alt+C"
    }
    val label = new Label {
      test = "Button clicks: " + 0
    }
    contents = new FlowPanel() {
      contents += button
      contents += label
      border = Swing.EmptyBorder(30,30,30,30)
    }
    listenTo(button)
    var numClicks = 0
    reactions += {
      case ButtonClicked(_) =>
        numClicks += 1
        label.text = "Button clicks: " + numClicks
    }
  }
}