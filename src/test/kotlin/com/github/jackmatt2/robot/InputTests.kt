package com.github.jackmatt2.robot

import com.github.jackmatt2.robot.output.InMemoryOutputHandler
import org.junit.Before
import org.junit.Test

class InputTests {

    lateinit var robot: Robot;
    lateinit var grid: Grid;
    lateinit var game: Game;
    lateinit var outputHandler: InMemoryOutputHandler;

    @Before
    fun before() {
        robot = Robot()
        grid = Grid(5,5)
        outputHandler = InMemoryOutputHandler()
        game = Game(robot, grid, outputHandler);
    }

    @Test
    fun `Entering nothing will do nothing`() {
        game.acceptCommand("")
        outputHandler.verifyNoInteractions()
    }

}