package com.example.cweek05a.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cweek05a.R
import com.example.cweek05a.model.DollClothData

@Composable
fun DollClothButton(
    modifier: Modifier = Modifier,
    clothData: DollClothData,
    onWearChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = clothData.wear,
            onCheckedChange = onWearChange,
        )
        Text(clothData.name)
    }
}

@Preview
@Composable
private fun DollItemPreview() {
    DollClothButton(clothData = DollClothData("arms", R.drawable.arms, true)) {}
}