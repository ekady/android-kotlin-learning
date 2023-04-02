package com.example.vaccines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vaccines.adapter.VaccineAdapter
import com.example.vaccines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // If no layout manager property on RecyclerView
        // binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = VaccineAdapter()
        binding.recyclerView.setHasFixedSize(true)
    }
}