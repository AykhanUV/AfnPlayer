package app.uvteam.afnplayer.core.data.mappers

import app.uvteam.afnplayer.core.common.Utils
import app.uvteam.afnplayer.core.database.relations.DirectoryWithMedia
import app.uvteam.afnplayer.core.database.relations.MediumWithInfo
import app.uvteam.afnplayer.core.model.Folder

fun DirectoryWithMedia.toFolder() = Folder(
    name = directory.name,
    path = directory.path,
    dateModified = directory.modified,
    parentPath = directory.parentPath,
    formattedMediaSize = Utils.formatFileSize(media.sumOf { it.mediumEntity.size }),
    mediaList = media.map(MediumWithInfo::toVideo),
)
