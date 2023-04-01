package com.example.worldcup.data

import com.example.worldcup.R
import com.example.worldcup.model.Country

object DataSource {
    val countries: List<Country> = listOf(
        Country("Brazil", 0, R.drawable.brazil),
        Country("Germany", 2, R.drawable.germany),
        Country("France", 1, R.drawable.france),
        Country("Saudi Arabia", 0, R.drawable.saudiarabia),
        Country("UK", 4, R.drawable.unitedkingdom),
        Country("United States", 2, R.drawable.unitedstates),
    )
}