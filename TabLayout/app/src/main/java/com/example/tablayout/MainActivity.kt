package com.example.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayout.adapter.TabViewPagerAdapter
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val tabList: List<String> = listOf("Movies", "Games", "Books")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = TabViewPagerAdapter(supportFragmentManager, lifecycle)

        // Connecting viewpager to tab layout
        TabLayoutMediator(binding.tab, binding.viewPager) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}