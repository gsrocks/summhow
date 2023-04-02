package com.summhow.summhow.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.summhow.summhow.feature.eventcreate.CREATE_EVENT_ROUTE
import com.summhow.summhow.feature.eventcreate.CreateEventRoute
import com.summhow.summhow.feature.eventcreate.navigateNoCreateEvent
import com.summhow.summhow.feature.home.HOME_ROUTE
import com.summhow.summhow.feature.home.HomeRoute

@Composable
fun SummhowNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(HOME_ROUTE) {
            HomeRoute(
                onNavigateToCreateEvent = navController::navigateNoCreateEvent
            )
        }

        composable(CREATE_EVENT_ROUTE) {
            CreateEventRoute()
        }
    }
}
