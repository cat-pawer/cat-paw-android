package com.catpaw.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatPawScaffold() {
    val navController = rememberNavController()
    var appBarState by remember { mutableStateOf(AppBarState()) }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = appBarState.navigationIconButton,
                title = appBarState.title,
                actions = appBarState.actions,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
    ) { paddingValues ->
        Surface {
            CatPawNavHost(
                paddingValues = paddingValues,
                changeAppBarState = { appBarState = it },
                navController = navController,
            )
        }
    }
}

data class AppBarState(
    val title: @Composable () -> Unit = {},
    val actions: @Composable RowScope.() -> Unit = {},
    val navigationIconButton: @Composable () -> Unit = {},
)