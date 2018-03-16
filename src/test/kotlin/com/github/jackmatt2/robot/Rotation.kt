package com.github.jackmatt2.robot

import org.junit.Test

class Rotation : AbstractTest() {

    @Test
    fun `I can rotate the robot LEFT in a full circle`() {
        game.acceptCommand("PLACE 0,0,NORTH")
        verifyReportOutputAfterCommand("LEFT", "Output: 0,0,WEST")
        verifyReportOutputAfterCommand("LEFT", "Output: 0,0,SOUTH")
        verifyReportOutputAfterCommand("LEFT", "Output: 0,0,EAST")
        verifyReportOutputAfterCommand("LEFT", "Output: 0,0,NORTH")
    }

    @Test
    fun `I can rotate the robot RIGHT in a full circle`() {
        game.acceptCommand("PLACE 0,0,NORTH")
        verifyReportOutputAfterCommand("RIGHT", "Output: 0,0,EAST")
        verifyReportOutputAfterCommand("RIGHT", "Output: 0,0,SOUTH")
        verifyReportOutputAfterCommand("RIGHT", "Output: 0,0,WEST")
        verifyReportOutputAfterCommand("RIGHT", "Output: 0,0,NORTH")
    }

}
