package com.github.jackmatt2.robot

import com.github.jackmatt2.robot.commands.CommandFactory
import com.github.jackmatt2.robot.output.OutputHandler

class Game(val robot: Robot, val grid: Grid, val outputHandler: OutputHandler) {

    fun acceptCommand(rawCommand: String) {
        val command = CommandFactory.getCommand(rawCommand);
    }

}
