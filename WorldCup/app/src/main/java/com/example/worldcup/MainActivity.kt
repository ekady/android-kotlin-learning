package com.example.worldcup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.worldcup.adapter.ListViewAdapter
import com.example.worldcup.data.DataSource
import com.example.worldcup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listView.adapter = ListViewAdapter(this, DataSource.countries)
    }
}