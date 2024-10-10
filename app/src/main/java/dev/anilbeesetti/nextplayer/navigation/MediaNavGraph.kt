package app.uvteam.afnplayer.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import app.uvteam.afnplayer.feature.player.PlayerActivity
import app.uvteam.afnplayer.feature.videopicker.navigation.mediaPickerFolderScreen
import app.uvteam.afnplayer.feature.videopicker.navigation.mediaPickerNavigationRoute
import app.uvteam.afnplayer.feature.videopicker.navigation.mediaPickerScreen
import app.uvteam.afnplayer.feature.videopicker.navigation.navigateToMediaPickerFolderScreen
import app.uvteam.afnplayer.settings.navigation.navigateToSettings

const val MEDIA_ROUTE = "media_nav_route"

fun NavGraphBuilder.mediaNavGraph(
    context: Context,
    navController: NavHostController,
) {
    navigation(
        startDestination = mediaPickerNavigationRoute,
        route = MEDIA_ROUTE,
    ) {
        mediaPickerScreen(
            onPlayVideo = context::startPlayerActivity,
            onFolderClick = navController::navigateToMediaPickerFolderScreen,
            onSettingsClick = navController::navigateToSettings,
        )
        mediaPickerFolderScreen(
            onNavigateUp = navController::navigateUp,
            onVideoClick = context::startPlayerActivity,
            onFolderClick = navController::navigateToMediaPickerFolderScreen,
        )
    }
}

fun Context.startPlayerActivity(uri: Uri) {
    val intent = Intent(Intent.ACTION_VIEW, uri, this, PlayerActivity::class.java)
    startActivity(intent)
}
