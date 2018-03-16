package com.github.jackmatt2.robot

import org.junit.Test

class BadInput : AbstractTest() {

    @Test
    fun `Entering nothing will show an error`() {
        placeRobotAtOrigin()
        game.acceptCommand("")
        outputHandler.verify("ERROR: Unknown command ''")
    }

}