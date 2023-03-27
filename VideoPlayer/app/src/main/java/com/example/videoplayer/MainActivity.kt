package com.example.videoplayer

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Displaying videos from local storage
        val videoView: VideoView = findViewById(R.id.videoView1)
        videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.sunset)
        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)


        // Displaying videos from internet
        val videoView2: VideoView = findViewById(R.id.videoView2)

        val uri =
            Uri.parse("https://assets.mixkit.co/videos/preview/mixkit-going-down-a-curved-highway-through-a-mountain-range-41576-large.mp4")

        videoView2.setVideoURI(uri)

        // Media Controller
        val mediaController2 = MediaController(this)

        mediaController2.setAnchorView(videoView2)
        mediaController2.setMediaPlayer(videoView2)
        videoView2.setMediaController(mediaController2)
    }
}