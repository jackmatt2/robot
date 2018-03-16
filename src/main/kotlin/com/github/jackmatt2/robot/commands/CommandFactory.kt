package com.github.jackmatt2.robot.commands

import com.github.jackmatt2.robot.Direction
import com.github.jackmatt2.robot.Game

object CommandFactory {

    private const val PLACEMENT_REGEX = "\\d+,\\d+,(NORTH|SOUTH|EAST|WEST)"

    fun getCommand(rawCommand: String, game: Game): Command {
        val args = rawCommand.split(" ")
                .map { it.trim() };

        val baseCommand = args.first()
        return when {
            args.size == 0 -> BadCommand(game,"No arguments were supplied")
            baseCommand == "PLACE" -> place(game, args)
            !game.robot.hasBeenPlaced() -> BadCommand(game,"You need to place the robot first!")
            baseCommand == "MOVE" -> Move(game)
            baseCommand == "LEFT" -> Left(game)
            baseCommand == "RIGHT" -> Right(game)
            baseCommand == "REPORT" -> Report(game)
            else -> BadCommand(game,"ERROR: Unknown command '${rawCommand}'")
        }
    }

    private fun place(game: Game, args: List<String>): Command {
        if (args.size != 2) {
            return BadCommand(game,"The PLACE accepts a single parameter")
        }

        val matches = PLACEMENT_REGEX.toRegex().matches(args[1])
        if (!matches) {
            return BadCommand(game,"Invalid placement ${args[1]}")
        }

        val parts = args[1].split(",")

        var x: Int = Integer.parseInt(parts[0]);
        var y: Int = Integer.parseInt(parts[1]);
        var direction: Direction = Direction.valueOf(parts[2]);

        if (!game.grid.canMove(x, y)) {
            return BadCommand(game,"Position ${x}, ${y} is off the grid!")
        }

        return Place(game, x, y, direction)
    }



}