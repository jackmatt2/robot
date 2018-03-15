package com.github.jackmatt2.robot.commands

import com.github.jackmatt2.robot.Direction

interface Command {
    fun execute()
}

class Place(x: Int, y: Int, facing: Direction): Command {
    override fun execute() {

    }
}

class Left(): Command {
    override fun execute() {

    }
}

class Right(): Command {
    override fun execute() {

    }
}

class Report(): Command {
    override fun execute() {

    }
}

class Unknown(): Command {
    override fun execute() {

    }

}