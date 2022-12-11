package com.task.operations

import com.task.OperationStrategy

class CustomOperation() : OperationStrategy {
    override fun doOperation(list: List<Int>): Double {
        val firstPart = list.take(list.size / 2)
        val secondPart = mutableListOf<Int>()
        list.forEachIndexed { index, item ->
            if (index >= list.size / 2) secondPart.add(-item)
        }
        return firstPart.sum().toDouble() / secondPart.sum()
    }
}