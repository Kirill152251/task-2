package com.task.operations

import com.task.OperationStrategy

class SumOperation() : OperationStrategy {
    override fun doOperation(list: List<Int>): Double {
        return if (list.isNotEmpty()) list.sum().toDouble() else 0.0
    }
}