package com.task

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    class Contract : ActivityResultContract<List<Int>, OperationsResult>() {

        override fun createIntent(context: Context, input: List<Int>): Intent {
            val intent = Intent(context, SecondActivity::class.java)
            val test = input.toIntArray()
            intent.putExtra(EXTRA_INPUT_MESSAGE, input.toIntArray())
            return intent
        }

        override fun parseResult(resultCode: Int, intent: Intent?): OperationsResult {
            intent ?: return OperationsResult(0, 0.0, 0.0)
            val list = intent.getIntArrayExtra(EXTRA_OUTPUT_MESSAGE)!!.toList()

            val randomListService = RandomListService()

            return OperationsResult(
                randomListService.getSumOfList(list),
                randomListService.getAverageOfList(list),
                randomListService.getCustomOperationResult(list)
            )
        }
    }

    companion object {
        private const val EXTRA_INPUT_MESSAGE = "MESSAGE"
        private const val EXTRA_OUTPUT_MESSAGE = "MESSAGE"
    }
}