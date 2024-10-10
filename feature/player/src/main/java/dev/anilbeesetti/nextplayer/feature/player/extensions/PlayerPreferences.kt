package app.uvteam.afnplayer.feature.player.extensions

import app.uvteam.afnplayer.core.model.FastSeek
import app.uvteam.afnplayer.core.model.PlayerPreferences

fun PlayerPreferences.shouldFastSeek(duration: Long): Boolean {
    return when (fastSeek) {
        FastSeek.ENABLE -> true
        FastSeek.DISABLE -> false
        FastSeek.AUTO -> duration >= minDurationForFastSeek
    }
}
