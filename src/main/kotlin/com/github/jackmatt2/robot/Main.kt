package com.github.jackmatt2.robot

import com.github.jackmatt2.robot.output.TerminalOutputHandler

fun main(args: Array<String>) {
    val outputHandler = TerminalOutputHandler()
    val grid = Grid(5,5)
    val game: Game = Game(grid, outputHandler);
    print("""
        Supported Commands
        --------------------------
        PLACE X,Y,{NORTH,SOUTH,EAST,WEST}
        MOVE
        LEFT
        RIGHT
        REPORT
        EXIT
        """)
    runLoop@ do {
        print("> ")
        val input: String = readLine() ?: return@runLoop
        game.acceptCommand(input)
    } while (input != "EXIT")

    outputHandler.handle("Bye!")
}
