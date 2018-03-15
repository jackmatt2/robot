package com.github.jackmatt2.robot

import com.github.jackmatt2.robot.output.TerminalOutputHandler

fun main(args: Array<String>) {
    val outputHandler = TerminalOutputHandler()
    val robot = Robot()
    val grid = Grid(5,5)
    val game: Game = Game(robot, grid, outputHandler);
    runLoop@ do {
        print(": ")
        val input: String = readLine() ?: return@runLoop
        game.acceptCommand(input)
    } while (input != "exit")

    println("Bye!")
}
