package app.uvteam.afnplayer.settings.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import app.uvteam.afnplayer.core.model.ScreenOrientation
import app.uvteam.afnplayer.core.ui.R

@Composable
fun ScreenOrientation.name(): String {
    val stringRes = when (this) {
        ScreenOrientation.AUTOMATIC -> R.string.automatic
        ScreenOrientation.LANDSCAPE -> R.string.landscape
        ScreenOrientation.LANDSCAPE_REVERSE -> R.string.landscape_reverse
        ScreenOrientation.LANDSCAPE_AUTO -> R.string.landscape_auto
        ScreenOrientation.PORTRAIT -> R.string.portrait
        ScreenOrientation.VIDEO_ORIENTATION -> R.string.video_orientation
    }

    return stringResource(id = stringRes)
}
