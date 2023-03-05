package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var buttonToPlayAgain: Button
    lateinit var buttonToCheck: Button

    var random: Int = nextInt(1, 1000)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        buttonToPlayAgain = findViewById(R.id.buttonToPlayAgain)
        buttonToCheck = findViewById(R.id.buttonToCheck)
        var count: Int = 0
        buttonToCheck.setOnClickListener {
            val number: Int = editText.text.toString().toInt()
            if (number < random) {
                textView.text = "Hint: It's higher!"
                count += 1
                editText.text.clear()
            } else if (number > random) {
                textView.text = "Hint: It's lower!"
                editText.text.clear()
                count += 1
            } else {
                textView.text = "Correct! use $count time to win"
                editText.text.clear()
            }
        }
        buttonToPlayAgain.setOnClickListener {
            reset()
            count = 0
        }

    }

    fun reset() {
        random = nextInt(1, 1000)
        textView.text = "Let's play!"
        editText.text.clear()
    }
}