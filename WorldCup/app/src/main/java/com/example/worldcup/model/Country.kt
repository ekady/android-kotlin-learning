package com.example.worldcup.model

import androidx.annotation.DrawableRes

data class Country(val name: String, val cupWins: Int, @DrawableRes val flagImage: Int) {}