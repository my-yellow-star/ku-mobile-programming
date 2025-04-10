package com.example.cweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cweek05a.model.ButtonType
import com.example.cweek05a.model.ImageData

@Composable
fun ImageItem(
    modifier: Modifier = Modifier,
    image: ImageData,
    onImageLike: () -> Unit,
    onImageDislike: () -> Unit
) {
    when (image.buttonType) {
        ButtonType.ICON -> {
            ImageWithButton(image = image.image) {
                ButtonWithIcon(likes = image.likes) {
                    onImageLike()
                }
            }
        }

        ButtonType.BADGE -> {
            ImageWithButton(image = image.image) {
                ButtonWithBadge(likes = image.likes) {
                    onImageLike()
                }
            }
        }

        ButtonType.EMOJI -> {
            ImageWithButton(image = image.image) {
                ButtonWithEmoji(
                    likes = image.likes,
                    dislikes = image.dislikes,
                    onClickLikes = {
                        onImageLike()
                    },
                    onClickDisLikes = {
                        onImageDislike()
                    }
                )
            }
        }
    }
}