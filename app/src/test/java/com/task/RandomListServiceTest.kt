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
        val list = listOf(15, 5, 16, 10)
        val expected = 11.5
        val actual = service.getAverageOfList(list)

        assertEquals(expected, actual)
    }

    @Test
    fun `average of empty list is 0`() {
        val list = emptyList<Int>()
        val expected = 0.0
        val actual = service.getAverageOfList(list)

        assertEquals(expected, actual)
    }
    @Test
    fun `sum of list is correct`() {
        val list = listOf(15, 5, 16, 10)
        val expected = 46
        val actual = service.getSumOfList(list)

        assertEquals(expected, actual)
    }
    @Test
    fun `sum of empty list is 0`() {
        val list = emptyList<Int>()
        val expected = 0
        val actual = service.getSumOfList(list)

        assertEquals(expected, actual)
    }
}