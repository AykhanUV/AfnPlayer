package app.uvteam.afnplayer.settings.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import app.uvteam.afnplayer.core.ui.designsystem.animatedComposable
import app.uvteam.afnplayer.settings.screens.appearance.AppearancePreferencesScreen

const val appearancePreferencesNavigationRoute = "appearance_preferences_route"

fun NavController.navigateToAppearancePreferences(navOptions: NavOptions? = navOptions { launchSingleTop = true }) {
    this.navigate(appearancePreferencesNavigationRoute, navOptions)
}

fun NavGraphBuilder.appearancePreferencesScreen(onNavigateUp: () -> Unit) {
    animatedComposable(route = appearancePreferencesNavigationRoute) {
        AppearancePreferencesScreen(onNavigateUp = onNavigateUp)
    }
}
