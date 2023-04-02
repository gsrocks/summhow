package com.summhow.summhow.feature.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.summhow.summhow.R
import com.summhow.summhow.feature.events.EventsRoute
import com.summhow.summhow.feature.profile.ProfileRoute
import com.summhow.summhow.ui.theme.SummhowTheme

const val HOME_ROUTE = "home"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(HOME_ROUTE, navOptions)
}

@Composable
fun HomeRoute(
    onNavigateToCreateEvent: () -> Unit
) {
    HomeScreen(
        onNavigateToCreateEvent = onNavigateToCreateEvent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToCreateEvent: () -> Unit
) {
    val destinations = listOf(
        HomeDestination.Events,
        HomeDestination.Profile
    )
    val homeNavController = rememberNavController()
    val navBackStackEntry by homeNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val shouldShowFab by remember(currentDestination) {
        derivedStateOf {
            currentDestination?.hierarchy?.any { it.route == HomeDestination.Events.route } == true
        }
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                destinations.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.labelResourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            homeNavController.navigate(screen.route) {
                                popUpTo(homeNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            AnimatedVisibility(visible = shouldShowFab, enter = fadeIn(), exit = fadeOut()) {
                FloatingActionButton(onClick = onNavigateToCreateEvent) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(R.string.create_event)
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = homeNavController,
            startDestination = HomeDestination.Events.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(HomeDestination.Events.route) {
                EventsRoute()
            }

            composable(HomeDestination.Profile.route) {
                ProfileRoute()
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    SummhowTheme {
        HomeScreen(
            onNavigateToCreateEvent = {}
        )
    }
}
