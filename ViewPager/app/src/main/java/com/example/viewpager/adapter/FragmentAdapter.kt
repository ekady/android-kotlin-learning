package com.example.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager.MainActivity
import com.example.viewpager.fragments.OneFragment
import com.example.viewpager.fragments.ThreeFragment
import com.example.viewpager.fragments.TwoFragment

class FragmentAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {
    private val fragmentSize = 3

    override fun getItemCount(): Int = fragmentSize

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OneFragment()
            1 -> TwoFragment()
            2 -> ThreeFragment()
            else -> OneFragment()
        }
    }
}