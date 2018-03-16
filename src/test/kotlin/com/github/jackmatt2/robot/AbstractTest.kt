package com.github.jackmatt2.robot

import com.github.jackmatt2.robot.output.InMemoryOutputHandler
import org.junit.Before

abstract class AbstractTest {

    lateinit var grid: Grid;
    lateinit var game: Game;
    lateinit var outputHandler: InMemoryOutputHandler;

    @Before
    fun before() {
        grid = Grid(5,5)
        outputHandler = InMemoryOutputHandler()
        game = Game(grid, outputHandler);
    }

    fun placeRobotAtOrigin() {
        game.acceptCommand("PLACE 0,0,NORTH")
    }

    fun verifyReportOutputAfterCommand(command: String, message: String) {
        game.acceptCommand(command)
        game.acceptCommand("REPORT")
        outputHandler.verify(message)
    }
}