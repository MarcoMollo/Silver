package aview

import controller.Controller

trait UIFactory {
  def processCommands(input: String)
}

object UIFactory {
  def apply(kind: String, controller: Controller) = kind match {
    case "GUI" => new GUI(controller).run()
    case "TUI" => new TUI(controller).run()
  }
}