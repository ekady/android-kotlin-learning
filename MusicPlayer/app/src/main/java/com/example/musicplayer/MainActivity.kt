package com.example.musicplayer

import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    // variables
    private var startTime = 0.0
    private var finalTime = 0.0
    private var forwardTime = 10000
    private var backwardTime = 10000
    private var oneTimeOnly = 0

    // Handler
    private var handler: Handler = Handler(Looper.getMainLooper())

    // Media Player
    private var mediaPlayer = MediaPlayer()
    private lateinit var timeText: TextView
    private lateinit var seekBar: SeekBar


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton: ImageButton = findViewById(R.id.play_button)
        val pauseButton: ImageButton = findViewById(R.id.pause_button)
        val forwardButton: ImageButton = findViewById(R.id.forward_button)
        val backButton: ImageButton = findViewById(R.id.back_button)

        val titleText: TextView = findViewById(R.id.song_title)
        timeText = findViewById(R.id.time_left_text)

        seekBar = findViewById(R.id.seek_bar)


        // Media Player
        mediaPlayer = MediaPlayer.create(this, R.raw.runaway)

        seekBar.isClickable = false


        // Adding Functionalities for the buttons
        playButton.setOnClickListener {
            mediaPlayer.start()

            finalTime = mediaPlayer.duration.toDouble()
            startTime = mediaPlayer.currentPosition.toDouble()

            if (oneTimeOnly == 0) {
                seekBar.max = finalTime.toInt()
                oneTimeOnly = 1
            }

            playButton.tooltipText = startTime.toString()
            seekBar.progress = startTime.toInt()

            handler.postDelayed(updateSongTime, 100)
        }


        // Setting the music title
        titleText.text = resources.getResourceEntryName(R.raw.runaway)


        // Stop Button
        pauseButton.setOnClickListener {
            mediaPlayer.pause()
        }


        // Forward Button
        forwardButton.setOnClickListener {
            val temp = startTime
            if ((temp + forwardTime) <= finalTime) {
                startTime += forwardTime
                mediaPlayer.seekTo(startTime.toInt())
            } else {
                Toast.makeText(
                    this, "Can't Jump forward", Toast.LENGTH_LONG
                ).show()
            }
        }

        backButton.setOnClickListener {
            val temp = startTime.toInt()

            if ((temp - backwardTime) > 0) {
                startTime -= backwardTime
                mediaPlayer.seekTo(startTime.toInt())
            } else {
                Toast.makeText(
                    this, "Can't Jump backward", Toast.LENGTH_LONG
                ).show()
            }
        }


    }

    // Creating the Runnable
    private val updateSongTime: Runnable = object : Runnable {
        override fun run() {
            startTime = mediaPlayer.currentPosition.toDouble()
            timeText.text = String.format(
                "%d min , %d sec",
                TimeUnit.MILLISECONDS.toMinutes(startTime.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(
                    startTime.toLong() - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(startTime.toLong())
                    )
                )
            )


            seekBar.progress = startTime.toInt()
            handler.postDelayed(this, 100)

        }
    }
}











