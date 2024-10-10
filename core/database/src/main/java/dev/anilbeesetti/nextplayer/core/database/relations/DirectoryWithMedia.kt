package app.uvteam.afnplayer.core.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import app.uvteam.afnplayer.core.database.entities.DirectoryEntity
import app.uvteam.afnplayer.core.database.entities.MediumEntity

data class DirectoryWithMedia(
    @Embedded val directory: DirectoryEntity,
    @Relation(
        entity = MediumEntity::class,
        parentColumn = "path",
        entityColumn = "parent_path",
    )
    val media: List<MediumWithInfo>,
)
