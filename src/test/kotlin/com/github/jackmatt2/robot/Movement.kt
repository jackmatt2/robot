package com.github.jackmatt2.robot

import org.junit.Test

class Movement : AbstractTest() {

    @Test
    fun `I can move the robot to the top left corner of the grid`() {
        game.acceptCommand("PLACE 0,0,NORTH")
        verifyReportOutputAfterCommand("MOVE", "Output: 0,1,NORTH")
        verifyReportOutputAfterCommand("MOVE", "Output: 0,2,NORTH")
        verifyReportOutputAfterCommand("MOVE", "Output: 0,3,NORTH")
    }

    @Test
    fun `I can move the robot to the bottom right corner of the grid`() {
        game.acceptCommand("PLACE 0,0,EAST")
        verifyReportOutputAfterCommand("MOVE", "Output: 1,0,EAST")
        verifyReportOutputAfterCommand("MOVE", "Output: 2,0,EAST")
        verifyReportOutputAfterCommand("MOVE", "Output: 3,0,EAST")
    }

    @Test
    fun `I cant make the robot fall off the grid in any direction`() {
        game.acceptCommand("PLACE 0,0,WEST")
        game.acceptCommand("MOVE")
        outputHandler.verify("Position -1, 0 is off the grid!")

        game.acceptCommand("PLACE 0,0,SOUTH")
        game.acceptCommand("MOVE")
        outputHandler.verify("Position 0, -1 is off the grid!")

        game.acceptCommand("PLACE 4,4,EAST")
        game.acceptCommand("MOVE")
        outputHandler.verify("Position 5, 4 is off the grid!")

        game.acceptCommand("PLACE 4,4,NORTH")
        game.acceptCommand("MOVE")
        outputHandler.verify("Position 4, 5 is off the grid!")
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

    private fun verifyReportOutputAfterCommand(command: String, message: String) {
        game.acceptCommand(command)
        game.acceptCommand("REPORT")
        outputHandler.verify(message)
    }

}
