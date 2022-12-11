package com.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val randomListService = RandomListService

    private val launcher = registerForActivityResult(SecondActivity.Contract()) {
        Log.i(
            "TAGS",
            "Sum: ${it.sum}. Average: ${it.average}. Custom operation result: ${it.customOperation}."
        )
        randomListService.setList(randomListService.getRandomList())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<MaterialButton>(R.id.got_to_second_activity_btn)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                randomListService.randomList.collect { list ->
                    button.setOnClickListener {
                        launcher.launch(list)
                    }
                }
            }
        }
        randomListService.setList(randomListService.getRandomList())
    }
}