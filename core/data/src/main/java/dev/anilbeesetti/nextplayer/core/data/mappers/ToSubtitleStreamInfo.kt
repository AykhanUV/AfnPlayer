package app.uvteam.afnplayer.core.data.mappers

import app.uvteam.afnplayer.core.database.entities.SubtitleStreamInfoEntity
import app.uvteam.afnplayer.core.model.SubtitleStreamInfo

fun SubtitleStreamInfoEntity.toSubtitleStreamInfo() = SubtitleStreamInfo(
    index = index,
    title = title,
    codecName = codecName,
    language = language,
    disposition = disposition,
)
