package com.task.operations

import com.task.OperationStrategy

class AverageOperation() : OperationStrategy {
    override fun doOperation(list: List<Int>): Double {
        return if (list.isNotEmpty()) list.sum().toDouble() / list.size else 0.0
    }
}