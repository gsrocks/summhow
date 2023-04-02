package com.summhow.summhow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.summhow.summhow.feature.home.HomeRoute
import com.summhow.summhow.ui.theme.SummhowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SummhowTheme {
                HomeRoute()
            }
        }
    }
}
