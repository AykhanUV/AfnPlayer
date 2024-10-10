package app.uvteam.afnplayer.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import app.uvteam.afnplayer.settings.Setting
import app.uvteam.afnplayer.settings.navigation.aboutPreferencesScreen
import app.uvteam.afnplayer.settings.navigation.appearancePreferencesScreen
import app.uvteam.afnplayer.settings.navigation.audioPreferencesScreen
import app.uvteam.afnplayer.settings.navigation.decoderPreferencesScreen
import app.uvteam.afnplayer.settings.navigation.folderPreferencesScreen
import app.uvteam.afnplayer.settings.navigation.mediaLibraryPreferencesScreen
import app.uvteam.afnplayer.settings.navigation.navigateToAboutPreferences
import app.uvteam.afnplayer.settings.navigation.navigateToAppearancePreferences
import app.uvteam.afnplayer.settings.navigation.navigateToAudioPreferences
import app.uvteam.afnplayer.settings.navigation.navigateToDecoderPreferences
import app.uvteam.afnplayer.settings.navigation.navigateToFolderPreferencesScreen
import app.uvteam.afnplayer.settings.navigation.navigateToMediaLibraryPreferencesScreen
import app.uvteam.afnplayer.settings.navigation.navigateToPlayerPreferences
import app.uvteam.afnplayer.settings.navigation.navigateToSubtitlePreferences
import app.uvteam.afnplayer.settings.navigation.playerPreferencesScreen
import app.uvteam.afnplayer.settings.navigation.settingsNavigationRoute
import app.uvteam.afnplayer.settings.navigation.settingsScreen
import app.uvteam.afnplayer.settings.navigation.subtitlePreferencesScreen

const val SETTINGS_ROUTE = "settings_nav_route"

fun NavGraphBuilder.settingsNavGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = settingsNavigationRoute,
        route = SETTINGS_ROUTE,
    ) {
        settingsScreen(
            onNavigateUp = navController::navigateUp,
            onItemClick = { setting ->
                when (setting) {
                    Setting.APPEARANCE -> navController.navigateToAppearancePreferences()
                    Setting.MEDIA_LIBRARY -> navController.navigateToMediaLibraryPreferencesScreen()
                    Setting.PLAYER -> navController.navigateToPlayerPreferences()
                    Setting.DECODER -> navController.navigateToDecoderPreferences()
                    Setting.AUDIO -> navController.navigateToAudioPreferences()
                    Setting.SUBTITLE -> navController.navigateToSubtitlePreferences()
                    Setting.ABOUT -> navController.navigateToAboutPreferences()
                }
            },
        )
        appearancePreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        mediaLibraryPreferencesScreen(
            onNavigateUp = navController::navigateUp,
            onFolderSettingClick = navController::navigateToFolderPreferencesScreen,
        )
        folderPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        playerPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        decoderPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        audioPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        subtitlePreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
        aboutPreferencesScreen(
            onNavigateUp = navController::navigateUp,
        )
    }
}
