package com.summhow.summhow.feature.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.summhow.summhow.R
import com.summhow.summhow.feature.events.EVENTS_ROUTE
import com.summhow.summhow.feature.profile.PROFILE_ROUTE

sealed class HomeDestination(
    val route: String,
    @StringRes val labelResourceId: Int,
    val icon: ImageVector
) {
    object Events : HomeDestination(EVENTS_ROUTE, R.string.events, Icons.Default.List)
    object Profile : HomeDestination(PROFILE_ROUTE, R.string.profile, Icons.Default.Person)
}
