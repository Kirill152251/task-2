package com.task

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RandomListServiceTest {

    private val service = RandomListService()

    @Test
    fun `list size is even`() {
        val list = service.getRandomList()
        assertTrue(list.size % 2 == 0)
    }

    @Test
    fun `average of list is correct`() {
        val list = listOf<Double>(15.0, 5.0, 10.0, 10.0)
        val expected = 10.0
        val actual = service.getAverageOfList(list)

        assertEquals(expected, actual)
    }

    @Test
    fun `average of empty list is 0`() {
        val list = emptyList<Double>()
        val expected = 0.0
        val actual = service.getAverageOfList(list)

        assertEquals(expected, actual)
    }
}