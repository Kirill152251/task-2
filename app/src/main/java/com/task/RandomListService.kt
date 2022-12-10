package com.task

import kotlin.random.Random

class RandomListService {

    fun getRandomList(): List<Int> {
        val randomSize = Random.nextInt(2, 100)

        val randomSet = mutableSetOf<Int>()
        for (i in 0 until randomSize) {
            randomSet.add(Random.nextInt(0, 1000))
        }
        if (randomSet.size % 2 != 0) {
            randomSet.remove(randomSet.last())
        }
        if (randomSet.size == 1) randomSet.add(randomSet.first() + Random.nextInt(1, 100))
        return randomSet.toList()
    }

    fun getAverageOfList(list: List<Int>): Double {
        return if (list.isNotEmpty()) list.sum().toDouble() / list.size else 0.0
    }
}