package com.task

import kotlin.random.Random

class RandomListService {

    fun getRandomList(): List<Double> {
        val randomSize = Random.nextInt(2, 100)
        val randomEvenSize = if (randomSize % 2 == 1) randomSize - 1 else randomSize
        return List(randomEvenSize) { Random.nextDouble(0.0, 100.0) }
    }

    fun getAverageOfList(list: List<Double>): Double {
        return if (list.isNotEmpty()) list.sum() / list.size else 0.0
    }
}