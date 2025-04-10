package com.example.cweek05a.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.cweek05a.R
import com.example.cweek05a.model.DollClothData

@Composable
fun DollImage(modifier: Modifier = Modifier, clothDataList: MutableList<DollClothData>) {
    Box(modifier = modifier) {
        Image(modifier = modifier, painter = painterResource(id = R.drawable.body), contentDescription = null)
        clothDataList.forEach { data ->
            if (data.wear)
                Image(modifier = modifier, painter = painterResource(id = data.resourceId), contentDescription = null)
        }
    }
}