package com.example.luckynumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    companion object {
        const val LUCKY_NUMBER = "lucky_number"
        const val KEY_LUCKY_NUMBER = "lucky_number_key"
    }

    private var currentNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val shareButton: Button = findViewById(R.id.share_button)
        val luckyNumber: TextView = findViewById(R.id.lucky_number)
        val luckyName: TextView = findViewById(R.id.lucky_name)

        val name = intent?.extras?.getString(LUCKY_NUMBER).toString()

        currentNumber = savedInstanceState?.getInt(KEY_LUCKY_NUMBER) ?: generateRandomNum()

        luckyNumber.text = currentNumber.toString()
        luckyName.text = name

        shareButton.setOnClickListener { shareData(name, currentNumber) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_LUCKY_NUMBER, currentNumber)
    }

    private fun generateRandomNum(): Int {
        return Random.nextInt(1000)
    }

    private fun shareData(name: String, num: Int) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "$name is lucky today")
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is $num")
        startActivity(intent)
    }
}