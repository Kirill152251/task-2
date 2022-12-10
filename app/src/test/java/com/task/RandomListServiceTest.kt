package com.task

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RandomListServiceTest {
    @Test
    fun test() {
        val list = RandomListService().getRandomList()
        assertTrue(list.size % 2 == 0)
    }
}