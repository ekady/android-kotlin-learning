package com.example.recyclercardview.data

import com.example.recyclercardview.R
import com.example.recyclercardview.model.Game

object DataSource {
    val games: List<Game> = listOf(
        Game("Horizon Chase", R.drawable.card1),
        Game("PUBG", R.drawable.card2),
        Game("Hero Ball 3", R.drawable.card3),
        Game("Hooked On You", R.drawable.card4),
        Game("Fifa 22", R.drawable.card5),
        Game("Fortnite", R.drawable.card6),
    )
}