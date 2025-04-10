package com.example.cweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.cweek05a.R

object DollClothListFactory {
    fun create() = mutableStateListOf(
        DollClothData(name = "arms", resourceId = R.drawable.arms, wear = true),
        DollClothData(name = "ears", resourceId = R.drawable.ears, wear = true),
        DollClothData(name = "eyes", resourceId = R.drawable.eyes, wear = true),
        DollClothData(name = "eyebrows", resourceId = R.drawable.eyebrows, wear = true),
        DollClothData(name = "glasses", resourceId = R.drawable.glasses, wear = true),
        DollClothData(name = "hat", resourceId = R.drawable.hat, wear = true),
        DollClothData(name = "mouth", resourceId = R.drawable.mouth, wear = true),
        DollClothData(name = "mustache", resourceId = R.drawable.mustache, wear = true),
        DollClothData(name = "nose", resourceId = R.drawable.nose, wear = true),
        DollClothData(name = "shoes", resourceId = R.drawable.shoes, wear = true),
    )
}