package com.github.jackmatt2.robot.commands

import com.github.jackmatt2.robot.Direction

object CommandFactory {

    fun getCommand(rawCommand: String): Command {
        val args = rawCommand.split(" ")
                .map { it.trim() };

        val baseCommand = args.first()
        return when {
            args.size == 0 -> Unknown()
            baseCommand == "PLACE" -> {
                // TODO extract co-ordinates
                val direction = Direction.valueOf("TODO");
                return Place(1,1, direction)
            }
            baseCommand == "LEFT" -> return Left()
            baseCommand == "RIGHT" -> return Right()
            baseCommand == "REPORT" -> return Report()
            else -> Unknown()
        }
    }

}