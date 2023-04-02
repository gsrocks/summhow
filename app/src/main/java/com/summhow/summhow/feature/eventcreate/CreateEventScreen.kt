package com.summhow.summhow.feature.eventcreate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.summhow.summhow.R

const val CREATE_EVENT_ROUTE = "create-event"

fun NavController.navigateNoCreateEvent(navOptions: NavOptions? = null) {
    navigate(CREATE_EVENT_ROUTE, navOptions)
}

@Composable
fun CreateEventRoute() {
    CreateEventScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateEventScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(R.string.close)
                        )
                    }
                },
                title = {
                    Text(
                        text = stringResource(R.string.create_event),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                actions = {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = stringResource(R.string.save))
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

        }
    }
}
