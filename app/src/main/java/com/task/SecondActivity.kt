package com.task

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.material.button.MaterialButton

class SecondActivity : AppCompatActivity() {

    private val randomListService = RandomListService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val button = findViewById<MaterialButton>(R.id.go_back_to_main_activity_btn)

        val randomList = intent.getIntArrayExtra(EXTRA_RANDOM_LIST)!!.toList()


        val outputIntent = Intent().apply {
            putExtra(EXTRA_SUM, randomListService.getSumOfList(randomList))
            putExtra(EXTRA_AVERAGE, randomListService.getAverageOfList(randomList))
            putExtra(EXTRA_CUSTOM_OPERATION, randomListService.getCustomOperationResult(randomList))
        }

        button.setOnClickListener {
            setResult(RESULT_OK, outputIntent)
            finish()
        }
    }

    class Contract : ActivityResultContract<List<Int>, OperationsResult>() {

        override fun createIntent(context: Context, input: List<Int>): Intent {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(EXTRA_RANDOM_LIST, input.toIntArray())
            return intent
        }

        override fun parseResult(resultCode: Int, intent: Intent?): OperationsResult {
            intent ?: return OperationsResult(0, 0.0, 0.0)
            val sum = intent.getIntExtra(EXTRA_SUM, 0)
            val average = intent.getDoubleExtra(EXTRA_AVERAGE, 0.0)
            val customOperation = intent.getDoubleExtra(EXTRA_CUSTOM_OPERATION, 0.0)
            return OperationsResult(sum, average, customOperation)
        }
    }

    companion object {
        private const val EXTRA_RANDOM_LIST = "RANDOM LIST"
        private const val EXTRA_SUM = "SUM"
        private const val EXTRA_AVERAGE = "AVERAGE"
        private const val EXTRA_CUSTOM_OPERATION = "CUSTOM"
    }
}