package com.task

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

object RandomListService {

    private val randomListPrivate = MutableStateFlow<List<Int>>(emptyList())
    val randomList = randomListPrivate.asStateFlow()

    fun setList(list: List<Int>) {
        randomListPrivate.value = list
    }

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
}

data class OperationsResult(
    val sum: Double,
    val average: Double,
    val customOperation: Double
)