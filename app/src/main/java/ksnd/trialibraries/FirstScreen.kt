package ksnd.trialibraries

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ksnd.trialibraries.libraries.konfetti.KonfettiScreen
import ksnd.trialibraries.libraries.pagecurl.PageCurlScreen

@Composable
fun FirstScreen() {
    fun NavGraphBuilder.fadeComposable(
        route: String,
        arguments: List<NamedNavArgument> = emptyList(),
        content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit,
    ) {
        composable(
            route = route,
            arguments = arguments,
            enterTransition = { fadeIn(tween(durationMillis = 400)) },
            exitTransition = { fadeOut(tween(durationMillis = 400)) },
            content = content,
        )
    }

    Surface(
        color = MaterialTheme.colorScheme.surface,
    ) {
        val navController = rememberNavController()
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxSize(),
        ) {
            NavHost(
                navController = navController,
                startDestination = NavRoute.Home.route,
            ) {
                fadeComposable(NavRoute.Home.route) {
                    HomeScreen(navController)
                }
                fadeComposable(NavRoute.Konfetti.route) {
                    KonfettiScreen(navController, hiltViewModel())
                }
                fadeComposable(NavRoute.PageCurl.route) {
                    PageCurlScreen(navController)
                }
            }
        }
    }
}

sealed class NavRoute(val route: String) {
    data object Home : NavRoute(route = "home")
    data object Konfetti : NavRoute(route = "konfetti")
    data object PageCurl : NavRoute(route = "page_curl")
}
