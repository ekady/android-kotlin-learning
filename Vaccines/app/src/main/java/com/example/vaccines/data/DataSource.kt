package com.example.vaccines.data

import com.example.vaccines.R
import com.example.vaccines.model.Vaccine

object DataSource {
    val vaccines: List<Vaccine> = listOf(
        Vaccine("Vaccine 1", R.drawable.vaccine1),
        Vaccine("Vaccine 2", R.drawable.vaccine4),
        Vaccine("Vaccine 3", R.drawable.vaccine5),
        Vaccine("Vaccine 4", R.drawable.vaccine6),
        Vaccine("Vaccine 5", R.drawable.vaccine7),
        Vaccine("Vaccine 6", R.drawable.vaccine8),
        Vaccine("Vaccine 7", R.drawable.vaccine9),
    )
}