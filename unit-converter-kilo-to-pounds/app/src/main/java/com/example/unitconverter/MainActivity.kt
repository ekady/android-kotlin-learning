package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit: EditText = findViewById(R.id.kilo_edt)
        val button: Button = findViewById(R.id.btn)
        val result: TextView = findViewById(R.id.result_text)
        val converter = Converter()

        button.setOnClickListener {
            val pounds = converter.convertToPounds(edit.text.toString().toDouble()).toString()
            result.text = pounds
            logging("Input: ${edit.text} Result $pounds pounds")
        }
    }

    private fun logging(message: String) {
        Log.v(TAG, message)
    }
}

class Converter {
    fun convertToPounds(kilos: Double): Double {
        return kilos * 2.20462
    }
}
