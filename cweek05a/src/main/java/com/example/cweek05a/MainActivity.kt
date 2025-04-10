package com.example.cweek05a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cweek05a.ui.theme.MyAppCTheme
import com.example.cweek05a.uicomponents.DollScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppCTheme {
                DollScreen()
            }
        }
    }
}