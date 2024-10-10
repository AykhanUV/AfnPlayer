package app.uvteam.afnplayer.core.data.mappers

import app.uvteam.afnplayer.core.database.entities.VideoStreamInfoEntity
import app.uvteam.afnplayer.core.model.VideoStreamInfo

fun VideoStreamInfoEntity.toVideoStreamInfo() = VideoStreamInfo(
    index = index,
    title = title,
    codecName = codecName,
    language = language,
    disposition = disposition,
    bitRate = bitRate,
    frameRate = frameRate,
    frameWidth = frameWidth,
    frameHeight = frameHeight,
)
