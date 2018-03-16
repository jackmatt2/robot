package com.github.jackmatt2.robot.commands

import com.github.jackmatt2.robot.Direction
import com.github.jackmatt2.robot.Game

interface Command {
    fun execute()
}

class Place(val game: Game, val x: Int, val y: Int, val direction: Direction): Command {
    override fun execute() {
        val position = game.robot.position;
        position.x = x
        position.y = y
        position.direction = direction
        game.robot.isPlaced = true
    }
}

class Left(val game: Game): Command {
    override fun execute() {
        game.turnRobotLeft()
    }
}

class Right(val game: Game): Command {
    override fun execute() {
        game.turnRobotRight()
    }
}

class Move(val game: Game): Command {
    override fun execute() {
        game.moveRobot()
    }
}

class Report(val game: Game): Command {
    override fun execute() {
        game.position()
    }
}

class BadCommand(val game: Game, val message: String): Command {
    override fun execute() {
        game.error(message)
    }
}