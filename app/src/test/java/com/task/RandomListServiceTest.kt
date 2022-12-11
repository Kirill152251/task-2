package com.task

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class RandomListServiceTest {

    private val service = RandomListService()

    @Test
    fun `list size is even`() {
        val list = service.getRandomList()
        assertTrue(list.size % 2 == 0)
    }

    @Test
    fun `list contain only unique items`() {
        val list = service.getRandomList()

        val expected = list.distinct().size
        val actual = list.size

        assertEquals(expected, actual)
    }
}