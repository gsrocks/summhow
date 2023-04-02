package com.summhow.summhow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.summhow.summhow.feature.home.HomeRoute
import com.summhow.summhow.ui.theme.SummhowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            SummhowTheme {
                HomeRoute()
            }
        }
    }
}
