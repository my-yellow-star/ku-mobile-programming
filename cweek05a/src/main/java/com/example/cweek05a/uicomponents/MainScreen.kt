package com.example.cweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cweek05a.uiexamples.ScrollToTopButton
import com.example.cweek05a.viewmodel.ImageViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val imageList = imageViewModel.imageList
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            state.firstVisibleItemIndex > 0
        }
    }
    val orientation = LocalConfiguration.current.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                state = state,
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                itemsIndexed(items = imageList) { index, image ->
                    ImageItem(
                        image = image,
                        onImageLike = { imageList[index] = image.copy(likes = image.likes + 1) },
                        onImageDislike = {
                            imageList[index] = image.copy(dislikes = image.dislikes + 1)
                        }
                    )
                }
            }
            AnimatedVisibility(visible = showButton) {
                ScrollToTopButton {
                    scope.launch {
                        state.scrollToItem(0)
                    }
                }
            }
        }
    } else {
        LazyRow(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            itemsIndexed(items = imageList) { index, image ->
                ImageItem(
                    image = image,
                    onImageLike = { imageList[index] = image.copy(likes = image.likes + 1) },
                    onImageDislike = {
                        imageList[index] = image.copy(dislikes = image.dislikes + 1)
                    }
                )
            }
        }
    }

//    var img1State by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.image1),
//                likes = 50,
//            )
//        )
//    }
//
//    var img2State by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.image2),
//                buttonType = ButtonType.EMOJI,
//                likes = 50,
//                dislikes = 5
//            )
//        )
//    }
//
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        ImageWithButton(image = img1State.image) {
//            ButtonWithBadge(likes = img1State.likes) {
//                img1State = img1State.copy(likes = img1State.likes + 1)
//            }
//        }
//        ImageWithButton(img2State.image) {
//            ButtonWithEmoji(
//                likes = img2State.likes,
//                dislikes = img2State.dislikes,
//                onClickLikes = {
//                    img2State = img2State.copy(likes = img2State.likes + 1)
//                },
//                onClickDisLikes = {
//                    img2State = img2State.copy(dislikes = img2State.dislikes + 1)
//                }
//            )
//        }
//    }
}