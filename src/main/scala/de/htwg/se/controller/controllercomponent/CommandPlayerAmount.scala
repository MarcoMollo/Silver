package de.htwg.se.controller.controllercomponent

import controllerbaseimpl.Controller
import de.htwg.se.model.gameconfigcomponent.gameconfigbaseimpl.GameConfig
import de.htwg.se.util.Command

class CommandPlayerAmount(controller: Controller, playerAmount: Int) extends Command {
  var gameConfig: GameConfig = controller.gameConfig.asInstanceOf[GameConfig]
  var gameState: GameState.Value = controller.gameState

  override def doStep(): Unit = controller.initGame(playerAmount)

  override def undoStep(): Unit = {
    controller.gameState = gameState
    controller.gameConfig = gameConfig
  }

  override def redoStep(): Unit = controller.initGame(playerAmount)
}
