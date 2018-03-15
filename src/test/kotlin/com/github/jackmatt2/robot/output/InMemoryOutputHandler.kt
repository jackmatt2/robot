package com.github.jackmatt2.robot.output

import junit.framework.TestCase
import java.util.*

class InMemoryOutputHandler(val queue: Queue<String> = ArrayDeque<String>()): OutputHandler {
    override fun handle(message: String) {
        queue.add(message)
    }

    fun verify(str: String) {
        TestCase.assertEquals(str, queue.peek());
    }

    fun verifyNoInteractions() {
        TestCase.assertEquals(0, queue.size);
    }
}