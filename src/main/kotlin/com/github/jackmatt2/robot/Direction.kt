package com.github.jackmatt2.robot

enum class Direction(
        val nextPosition: (x: Int, y: Int) -> Pair<Int, Int>,
        val leftOf: () -> Direction,
        val rightOf: () -> Direction) {
    NORTH({x,y -> x to y + 1}, {WEST}, {EAST}),
    EAST({x,y -> x + 1 to y}, {NORTH}, {SOUTH}),
    SOUTH({x,y -> x to y - 1}, {EAST}, {WEST}),
    WEST({x,y -> x - 1 to y}, {SOUTH}, {NORTH});
}