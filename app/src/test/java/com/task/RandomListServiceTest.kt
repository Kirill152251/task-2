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
}