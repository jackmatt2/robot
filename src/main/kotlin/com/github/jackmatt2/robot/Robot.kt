package com.github.jackmatt2.robot

data class Position(var x: Int, var y: Int, var direction: Direction) {
    fun display() = "Output: ${x},${y},${direction}"
}

class Robot (var isPlaced: Boolean = false) {

    val position = Position(-1,-1, Direction.NORTH)

    fun move(x: Int, y: Int) {
        position.x = x
        position.y = y
    }

    fun left() {
        position.direction = position.direction.leftOf()
    }

    fun right() {
        position.direction = position.direction.rightOf()
    }

}