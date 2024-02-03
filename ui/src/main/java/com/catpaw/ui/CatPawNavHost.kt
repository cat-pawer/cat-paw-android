package com.catpaw.ui

import android.util.Log
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.catpaw.ui.ScreenNavType.RecruitDetailNav
import com.catpaw.ui.ScreenNavType.RecruitNav
import com.catpaw.ui.recruit.RecruitScreen
import com.catpaw.ui.recruitdetail.RecruitDetailScreen

@Composable
fun CatPawNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues = PaddingValues(16.dp),
    changeAppBarState: (AppBarState) -> Unit = { AppBarState() },
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    NavHost(navController = navController, startDestination = RecruitNav.route) {
        setComposable(RecruitNav.route) {
            RecruitScreen(
                changeAppBarState = changeAppBarState, onRecruitDetailClick = {
                    navController.navigate(RecruitDetailNav.createRoute(it)) {
                        launchSingleTop = true
                    }
                }, modifier = Modifier.padding(paddingValues)
            )
        }
        setComposable(
            route = RecruitDetailNav.route,
            arguments = listOf(navArgument(NAV_PATH_VAR_ID) {
                type = NavType.IntType
            })
        ) {
            RecruitDetailScreen(
                modifier = Modifier.padding(paddingValues),
                changeAppBarState = changeAppBarState,
                onNavClick = {
                    navController.navigateUp()
                },
            )
        }
    }
}

fun NavGraphBuilder.setComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    speedAnimation: Int = 300,
    enterTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Right,
            tween(speedAnimation)
        ) + fadeIn(tween(speedAnimation))
    },
    exitTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            tween(speedAnimation)
        ) + fadeOut(tween(speedAnimation))
    },
    popEnterTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Right,
            tween(speedAnimation)
        ) + fadeIn(tween(speedAnimation))
    },
    popExitTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            tween(speedAnimation)
        ) + fadeOut(tween(speedAnimation))
    },
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit,
) {
    return composable(
        route = route,
        arguments = arguments,
        deepLinks = deepLinks,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition,
        content = content
    )
}

private sealed class ScreenNavType(val route: String) {
    protected val TAG = "ScreenNavType"

    data object RecruitNav : ScreenNavType("recruit")
    data object RecruitDetailNav : ScreenNavType("recruit_detail/{${NAV_PATH_VAR_ID}}") {

        fun createRoute(id: Int) = "recruit_detail/$id".also { Log.d(TAG, "createRoute: $it") }
    }
}

internal const val NAV_PATH_VAR_ID = "recruit_detail_id"