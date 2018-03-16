package com.github.jackmatt2.robot

class Grid(val sizeX: Int, val sizeY: Int) {

    fun canMove(x: Int, y: Int): Boolean {
        val isWithinXBounds = x >= 0 && x < sizeX;
        val isWithinYBounds = y >= 0 && y < sizeY;
        return isWithinXBounds && isWithinYBounds;
    }

}