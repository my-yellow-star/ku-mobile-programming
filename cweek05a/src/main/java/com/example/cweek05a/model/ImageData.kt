package com.example.cweek05a.model

import androidx.compose.runtime.saveable.listSaver

data class ImageData(
    val image: ImageUri,
    val buttonType: ButtonType = ButtonType.BADGE,
    var likes: Int = 0,
    var dislikes: Int = 0
) {
    companion object {
        val imageSaver = listSaver<ImageData, Any>(
            save = { item ->
                listOf(
                    when (item.image) {
                        is ImageUri.ResImage -> item.image.resID
                        is ImageUri.WebImage -> item.image.webUrl
                    },
                    item.buttonType.name,
                    item.likes,
                    item.dislikes
                )
            },
            restore = { list ->
                val imgValue = list[0]
                val image = when (imgValue) {
                    is Int -> ImageUri.ResImage(imgValue)
                    is String -> ImageUri.WebImage(imgValue)
                    else -> throw IllegalArgumentException("타입 오류")
                }
                ImageData(
                    image = image,
                    buttonType = ButtonType.valueOf(list[1] as String),
                    likes = list[2] as Int,
                    dislikes = list[3] as Int
                )
            }
        )
    }
}
