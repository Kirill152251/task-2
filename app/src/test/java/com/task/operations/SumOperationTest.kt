package com.task.operations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SumOperationTest {

    private val operation = SumOperation()

    @Test
    fun `sum of list is correct`() {
        val list = listOf(15, 5, 16, 10)
        val expected = 46.0
        val actual = operation.doOperation(list)

        assertEquals(expected, actual)
    }

    @Test
    fun `sum of empty list is 0`() {
        val list = emptyList<Int>()
        val expected = 0.0
        val actual = operation.doOperation(list)

        assertEquals(expected, actual)
    }
}