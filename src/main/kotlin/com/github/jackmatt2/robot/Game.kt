package com.github.jackmatt2.robot

import com.github.jackmatt2.robot.commands.CommandFactory
import com.github.jackmatt2.robot.output.OutputHandler

class Game(
        val grid: Grid,
        private val outputHandler: OutputHandler,
        val robot: Robot = Robot()) {

    fun acceptCommand(rawCommand: String) {
        val command = CommandFactory.getCommand(rawCommand, this);
        command.execute()
    }

    fun moveRobotConstrainedOnGrid() {
        val (x,y) = robot.nextMove()
        if (grid.canMove(x, y)) {
            robot.move()
        } else {
            outputHandler.handle("Position ${x}, ${y} is off the grid!")
        }
    }

    fun print(message: String) {
        outputHandler.handle(message);
    }

}
