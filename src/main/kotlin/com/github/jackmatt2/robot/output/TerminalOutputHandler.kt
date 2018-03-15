package com.github.jackmatt2.robot.output

class TerminalOutputHandler: OutputHandler {

    override fun handle(message: String) {
        println(message)
    }

}