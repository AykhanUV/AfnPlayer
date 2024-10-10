package app.uvteam.afnplayer.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.uvteam.afnplayer.core.database.dao.DirectoryDao
import app.uvteam.afnplayer.core.database.dao.MediumDao
import app.uvteam.afnplayer.core.database.entities.AudioStreamInfoEntity
import app.uvteam.afnplayer.core.database.entities.DirectoryEntity
import app.uvteam.afnplayer.core.database.entities.MediumEntity
import app.uvteam.afnplayer.core.database.entities.SubtitleStreamInfoEntity
import app.uvteam.afnplayer.core.database.entities.VideoStreamInfoEntity

@Database(
    entities = [
        DirectoryEntity::class,
        MediumEntity::class,
        VideoStreamInfoEntity::class,
        AudioStreamInfoEntity::class,
        SubtitleStreamInfoEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class MediaDatabase : RoomDatabase() {

    abstract fun mediumDao(): MediumDao

    abstract fun directoryDao(): DirectoryDao

    companion object {
        const val DATABASE_NAME = "media_db"
    }
}
