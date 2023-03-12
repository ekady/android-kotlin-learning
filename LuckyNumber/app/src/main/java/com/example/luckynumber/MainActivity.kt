package com.example.luckynumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateButton: Button = findViewById(R.id.button_generate)
        val nameInput: EditText = findViewById(R.id.input_name)

        generateButton.setOnClickListener {
            val name = nameInput.text.toString()
            val intent = Intent(this, LuckyNumberActivity::class.java)
            intent.putExtra(LuckyNumberActivity.LUCKY_NUMBER, name)
            startActivity(intent)
        }
    }
}