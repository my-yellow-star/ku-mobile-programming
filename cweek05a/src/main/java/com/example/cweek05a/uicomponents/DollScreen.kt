package com.example.cweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cweek05a.viewmodel.DollClothViewModel

@Composable
fun DollScreen(
    modifier: Modifier = Modifier,
    clothViewModel: DollClothViewModel = viewModel()
) {
    var clothDataList = clothViewModel.clothList
    val orientation = LocalConfiguration.current.orientation

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    DollImage(modifier = Modifier.size(300.dp), clothDataList = clothDataList)
                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                        itemsIndexed(clothDataList) { index, item ->
                            DollClothButton(
                                modifier = modifier,
                                clothData = item
                            ) { wear ->
                                clothDataList[index] = item.copy(wear = wear)
                            }
                        }
                    }
                }
            } else {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    DollImage(modifier = Modifier.size(300.dp), clothDataList = clothDataList)
                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                        itemsIndexed(clothDataList) { index, item ->
                            DollClothButton(
                                modifier = modifier,
                                clothData = item
                            ) { wear ->
                                clothDataList[index] = item.copy(wear = wear)
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "201814126 조찬아",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun DollPreview() {
    DollScreen()
}