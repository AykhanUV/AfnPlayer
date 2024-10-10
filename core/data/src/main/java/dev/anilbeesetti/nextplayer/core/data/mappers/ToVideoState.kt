package app.uvteam.afnplayer.core.data.mappers

import app.uvteam.afnplayer.core.data.models.VideoState
import app.uvteam.afnplayer.core.database.converter.UriListConverter
import app.uvteam.afnplayer.core.database.entities.MediumEntity

fun MediumEntity.toVideoState(): VideoState {
    return VideoState(
        path = path,
        position = playbackPosition,
        audioTrackIndex = audioTrackIndex,
        subtitleTrackIndex = subtitleTrackIndex,
        playbackSpeed = playbackSpeed,
        externalSubs = UriListConverter.fromStringToList(externalSubs),
        videoScale = videoScale,
    )
}
