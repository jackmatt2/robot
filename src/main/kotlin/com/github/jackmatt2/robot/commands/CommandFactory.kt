package com.github.jackmatt2.robot.commands

import com.github.jackmatt2.robot.Direction
import com.github.jackmatt2.robot.Game
import com.github.jackmatt2.robot.Position

object CommandFactory {

    fun getCommand(rawCommand: String, game: Game): Command {
        val args = rawCommand.split(" ")
                .map { it.trim() };

        val baseCommand = args.first()
        return when {
            args.size == 0 -> BadCommand(game,"No arguments were supplied")
            baseCommand == "PLACE" -> {
                if (args.size != 2) {
                    return BadCommand(game,"The PLACE accepts a single parameter")
                }

                val parts = args[1].split(",")

                if (parts.size != 3) {
                    return BadCommand(game,"The PLACE command needs exactly 3 comma separated values")
                }

                var x: Int? = null;
                var y: Int? = null;
                var direction: Direction? = null;

                try {
                    x = Integer.parseInt(parts[0])
                } catch (e: NumberFormatException) {
                    return BadCommand(game,"The X coordinate should be an integer")
                }

                try {
                    y = Integer.parseInt(parts[1])
                } catch (e: NumberFormatException) {
                    return BadCommand(game,"The X coordinate should be an integer")
                }

                try {
                    direction = Direction.valueOf(parts[2])
                } catch (e: NumberFormatException) {
                    return BadCommand(game,"Unable to recognise direction")
                }

                if (!game.grid.canMove(x, y)) {
                    return BadCommand(game,"Position ${x}, ${y} is off the grid!")
                }

                return Place(game, x,y, direction)
            }
            !game.robot.isPlaced -> BadCommand(game,"You need to place the robot first!")
            baseCommand == "MOVE" -> return Move(game)
            baseCommand == "LEFT" -> return Left(game)
            baseCommand == "RIGHT" -> return Right(game)
            baseCommand == "REPORT" -> return Report(game)
            else -> BadCommand(game,"ERROR: Unknown command '${rawCommand}'")
        }
    }



}