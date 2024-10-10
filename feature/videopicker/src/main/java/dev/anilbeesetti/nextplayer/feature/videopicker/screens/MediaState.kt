package app.uvteam.afnplayer.feature.videopicker.screens

import app.uvteam.afnplayer.core.model.Folder

sealed interface MediaState {
    data object Loading : MediaState
    data class Success(val data: Folder?) : MediaState
}
