package com.example.recyclercardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclercardview.adapter.GameAdapter
import com.example.recyclercardview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = GameAdapter()
        binding.recyclerView.setHasFixedSize(true)
    }
}