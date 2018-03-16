package com.github.jackmatt2.robot

import org.junit.Test

class Rotation : AbstractTest() {

    @Test
    fun `I can rotate the robot LEFT in a full circle`() {
        game.acceptCommand("PLACE 0,0,NORTH")
        assertOutput("LEFT", "Output: 0,0,WEST")
        assertOutput("LEFT", "Output: 0,0,SOUTH")
        assertOutput("LEFT", "Output: 0,0,EAST")
        assertOutput("LEFT", "Output: 0,0,NORTH")
    }

    @Test
    fun `I can rotate the robot RIGHT in a full circle`() {
        game.acceptCommand("PLACE 0,0,NORTH")
        assertOutput("RIGHT", "Output: 0,0,EAST")
        assertOutput("RIGHT", "Output: 0,0,SOUTH")
        assertOutput("RIGHT", "Output: 0,0,WEST")
        assertOutput("RIGHT", "Output: 0,0,NORTH")
    }

    private fun assertOutput(command: String, message: String) {
        game.acceptCommand(command)
        game.acceptCommand("REPORT")
        outputHandler.verify(message)
    }

}
