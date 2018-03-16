package com.github.jackmatt2.robot

import org.junit.Test

class Movement : AbstractTest() {

    @Test
    fun `I can move the robot to the top left corner of the grid`() {
        game.acceptCommand("PLACE 0,0,NORTH")
        assertOutput("MOVE", "Output: 0,1,NORTH")
        assertOutput("MOVE", "Output: 0,2,NORTH")
        assertOutput("MOVE", "Output: 0,3,NORTH")
    }

    @Test
    fun `I can move the robot to the bottom right corner of the grid`() {
        game.acceptCommand("PLACE 0,0,EAST")
        assertOutput("MOVE", "Output: 1,0,EAST")
        assertOutput("MOVE", "Output: 2,0,EAST")
        assertOutput("MOVE", "Output: 3,0,EAST")
    }

    @Test
    fun `I can move the robot to the top right corner of the grid`() {
        game.acceptCommand("PLACE 0,0,NORTH")
        repeat(3, {game.acceptCommand("MOVE")})
        game.acceptCommand("RIGHT")
        repeat(3, {game.acceptCommand("MOVE")})
        game.acceptCommand("REPORT")
        outputHandler.verify("Output: 3,3,EAST")
    }

    private fun assertOutput(command: String, message: String) {
        game.acceptCommand(command)
        game.acceptCommand("REPORT")
        outputHandler.verify(message)
    }

}
