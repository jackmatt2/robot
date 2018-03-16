package com.github.jackmatt2.robot

class Grid(val sizeX: Int, val sizeY: Int) {

    fun canMove(x: Int, y: Int): Boolean {
        val isWithoutXBounds = x >= 0 && x < sizeX;
        val isWithoutYBounds = y >= 0 && y < sizeY;
        return isWithoutXBounds && isWithoutYBounds;
    }

}