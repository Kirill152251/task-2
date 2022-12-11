package com.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private val randomListService = RandomListService()

    private val launcher = registerForActivityResult(SecondActivity.Contract()) {
        Log.i(
            "TAGS",
            "Sum: ${it.sum}. Average: ${it.average}. Custom operation result: ${it.customOperation}."
        )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<MaterialButton>(R.id.got_to_second_activity_btn)

        button.setOnClickListener {
            launcher.launch(randomListService.getRandomList())
        }
    }
}