package com.task.operations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AverageOperationTest {

    private val operation = AverageOperation()

    @Test
    fun `average of list is correct`() {
        val list = listOf(15, 5, 16, 10)
        val expected = 11.5
        val actual = operation.doOperation(list)

        assertEquals(expected, actual)
    }

    @Test
    fun `average of empty list is 0`() {
        val list = emptyList<Int>()
        val expected = 0.0
        val actual = operation.doOperation(list)

        assertEquals(expected, actual)
    }
}