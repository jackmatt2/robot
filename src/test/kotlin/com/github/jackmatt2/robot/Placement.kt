package com.github.jackmatt2.robot

import junit.framework.TestCase
import org.junit.Test

class Placement: AbstractTest() {

    @Test
    fun `I can place the robot`() {
        TestCase.assertEquals(false, game.robot.hasBeenPlaced())
        game.acceptCommand("PLACE 0,0,NORTH")
        TestCase.assertEquals(true, game.robot.hasBeenPlaced())
    }

    @Test
    fun `I can place the robot again`() {
        TestCase.assertEquals(false, game.robot.hasBeenPlaced())
        game.acceptCommand("PLACE 0,0,NORTH")
        TestCase.assertEquals(true, game.robot.hasBeenPlaced())
        game.acceptCommand("PLACE 1,1,SOUTH")
        game.acceptCommand("REPORT")
        outputHandler.verify("Output: 1,1,SOUTH")
    }

    @Test
    fun `I can't place the robot off the the grid`() {
        TestCase.assertEquals(false, game.robot.hasBeenPlaced())
        game.acceptCommand("PLACE -1,0,NORTH")
        outputHandler.verify("Invalid placement -1,0,NORTH")

        game.acceptCommand("PLACE 0,5,NORTH")
        outputHandler.verify("Position 0, 5 is off the grid!")

        game.acceptCommand("PLACE 5,0,NORTH")
        outputHandler.verify("Position 5, 0 is off the grid!")

        game.acceptCommand("PLACE 5,5,NORTH")
        outputHandler.verify("Position 5, 5 is off the grid!")
    }

    @Test
    fun `I need to place the robot before executing the MOVE command`() {
        TestCase.assertEquals(false, game.robot.hasBeenPlaced())
        game.acceptCommand("MOVE")
        outputHandler.verify("You need to place the robot first!")
    }

    @Test
    fun `I need to place the robot before executing the LEFT command`() {
        TestCase.assertEquals(false, game.robot.hasBeenPlaced())
        game.acceptCommand("LEFT")
        outputHandler.verify("You need to place the robot first!")
    }

    @Test
    fun `I need to place the robot before executing the RIGHT command`() {
        TestCase.assertEquals(false, game.robot.hasBeenPlaced())
        game.acceptCommand("RIGHT")
        outputHandler.verify("You need to place the robot first!")
    }

    @Test
    fun `I need to place the robot before executing the REPORT command`() {
        TestCase.assertEquals(false, game.robot.hasBeenPlaced())
        game.acceptCommand("REPORT")
        outputHandler.verify("You need to place the robot first!")
    }

}
