package com.github.jackmatt2.robot

import com.github.jackmatt2.robot.commands.CommandFactory
import com.github.jackmatt2.robot.commands.Place
import com.github.jackmatt2.robot.output.OutputHandler

class Game(
        val grid: Grid,
        private val outputHandler: OutputHandler,
        val robot: Robot = Robot()) {

    fun position() {
        outputHandler.handle(robot.position.display())
    }

    fun acceptCommand(rawCommand: String) {
        val command = CommandFactory.getCommand(rawCommand, this);
        command.execute()
    }

    fun turnRobotLeft() {
       robot.left()
    }

    fun turnRobotRight() {
        robot.right()
    }

    fun moveRobot() {
        val (currentX, currentY) = robot.position
        val (x,y) = robot.position.direction.nextPosition(currentX, currentY)
        if (grid.canMove(x, y)) {
            robot.move(x, y)
        } else {
            outputHandler.handle("Position ${x}, ${y} is off the grid!")
        }
    }

    fun error(message: String) {
        outputHandler.handle(message);
    }

}
