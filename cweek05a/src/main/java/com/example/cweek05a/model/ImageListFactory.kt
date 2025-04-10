package com.example.cweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.cweek05a.R

object ImageListFactory {
    fun makeImageList() = mutableStateListOf(
        ImageData(
            image = ImageUri.ResImage(R.drawable.image1),
            likes = 50,
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.image2),
            buttonType = ButtonType.EMOJI,
            likes = 50,
            dislikes = 5
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.image3),
            buttonType = ButtonType.ICON,
            likes = 100,
        )
    )
}