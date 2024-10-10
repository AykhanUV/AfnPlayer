package app.uvteam.afnplayer.core.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import app.uvteam.afnplayer.core.database.entities.AudioStreamInfoEntity
import app.uvteam.afnplayer.core.database.entities.MediumEntity
import app.uvteam.afnplayer.core.database.entities.SubtitleStreamInfoEntity
import app.uvteam.afnplayer.core.database.entities.VideoStreamInfoEntity

data class MediumWithInfo(
    @Embedded val mediumEntity: MediumEntity,
    @Relation(
        parentColumn = "uri",
        entityColumn = "medium_uri",
    )
    val videoStreamInfo: VideoStreamInfoEntity?,
    @Relation(
        parentColumn = "uri",
        entityColumn = "medium_uri",
    )
    val audioStreamsInfo: List<AudioStreamInfoEntity>,
    @Relation(
        parentColumn = "uri",
        entityColumn = "medium_uri",
    )
    val subtitleStreamsInfo: List<SubtitleStreamInfoEntity>,
)
