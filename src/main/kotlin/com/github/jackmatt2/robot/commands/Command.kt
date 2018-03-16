package com.github.jackmatt2.robot.commands

import com.github.jackmatt2.robot.Direction
import com.github.jackmatt2.robot.Game

interface Command {
    fun execute()
}

class Place(val game: Game, val x: Int, val y: Int, val direction: Direction): Command {
    override fun execute() {
        game.robot.place(x,y,direction)
    }
}

class Left(val game: Game): Command {
    override fun execute() {
        game.robot.left()
    }
}

class Right(val game: Game): Command {
    override fun execute() {
        game.robot.right()
    }
}

class Move(val game: Game): Command {
    override fun execute() {
        game.moveRobotConstrainedOnGrid()
    }
}

class Report(val game: Game): Command {
    override fun execute() {
        game.print(game.robot.display())
    }
}

class BadCommand(val game: Game, val message: String): Command {
    override fun execute() {
        game.print(message)
    }
}