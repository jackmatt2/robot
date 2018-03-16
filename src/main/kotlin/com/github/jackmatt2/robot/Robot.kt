package com.github.jackmatt2.robot

data class Position(var x: Int, var y: Int, var direction: Direction)

class Robot {

    private var isPlaced: Boolean = false
    private val position: Position = Position(-1,-1, Direction.NORTH)

    fun hasBeenPlaced() = isPlaced

    fun move() {
        val (x, y) = nextMove()
        position.x = x
        position.y = y
    }

    fun nextMove() = position.direction.nextPosition(position.x,position.y)

    fun left() {
        position.direction = position.direction.leftOf()
    }

    fun right() {
        position.direction = position.direction.rightOf()
    }

    fun display() = "Output: ${position.x},${position.y},${position.direction}"

    fun place(x: Int, y: Int, direction: Direction) {
        position.x = x
        position.y = y
        position.direction = direction
        isPlaced = true
    }

}