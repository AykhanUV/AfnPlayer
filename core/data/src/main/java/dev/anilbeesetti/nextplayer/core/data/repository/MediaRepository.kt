package app.uvteam.afnplayer.core.data.repository

import android.net.Uri
import app.uvteam.afnplayer.core.data.models.VideoState
import app.uvteam.afnplayer.core.model.Folder
import app.uvteam.afnplayer.core.model.Video
import kotlinx.coroutines.flow.Flow

interface MediaRepository {
    fun getVideosFlow(): Flow<List<Video>>
    fun getVideosFlowFromFolderPath(folderPath: String): Flow<List<Video>>
    fun getFoldersFlow(): Flow<List<Folder>>
    suspend fun saveVideoState(
        uri: String,
        position: Long,
        audioTrackIndex: Int?,
        subtitleTrackIndex: Int?,
        playbackSpeed: Float?,
        externalSubs: List<Uri>,
        videoScale: Float,
    )
    suspend fun getVideoState(uri: String): VideoState?
}
