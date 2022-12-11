package com.task.operations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CustomOperationTest {

    private val operation = CustomOperation()

    @Test
    fun `custom operation return correct answer`() {
        val list = listOf(13,32,32,7)
        val expected = (13 + 32).toDouble() / (- 32 - 7)
        val actual = operation.doOperation(list)

        assertEquals(expected, actual)
    }
}