package com.example.frenchcolor

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayTheColor(view: View) {
        val button: Button = view as Button

        // Get warning using resources.getIdentifier
        /*
        val mediaPlayer: MediaPlayer = MediaPlayer.create(
            this,
            resources.getIdentifier(button.tag.toString(), "raw", packageName)
        )
        */

        // Alternative
        val resId = when (button.tag.toString()) {
            "black" -> R.raw.black
            "green" -> R.raw.green
            "purple" -> R.raw.purple
            "red" -> R.raw.red
            "yellow" -> R.raw.yellow
            else -> throw IllegalArgumentException("Invalid resource name")
        }
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, resId)

        mediaPlayer.start()
    }
}