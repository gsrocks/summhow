package com.summhow.summhow.feature.events

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

const val EVENTS_ROUTE = "events"

@Composable
fun EventsRoute() {
    EventsScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EventsScreen() {

}
