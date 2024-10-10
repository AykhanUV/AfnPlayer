package app.uvteam.afnplayer.core.media

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import app.uvteam.afnplayer.core.media.services.LocalMediaService
import app.uvteam.afnplayer.core.media.services.MediaService
import app.uvteam.afnplayer.core.media.sync.LocalMediaInfoSynchronizer
import app.uvteam.afnplayer.core.media.sync.LocalMediaSynchronizer
import app.uvteam.afnplayer.core.media.sync.MediaInfoSynchronizer
import app.uvteam.afnplayer.core.media.sync.MediaSynchronizer
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MediaModule {

    @Binds
    @Singleton
    fun bindsMediaSynchronizer(
        mediaSynchronizer: LocalMediaSynchronizer,
    ): MediaSynchronizer

    @Binds
    @Singleton
    fun bindsMediaInfoSynchronizer(
        mediaInfoSynchronizer: LocalMediaInfoSynchronizer,
    ): MediaInfoSynchronizer

    @Binds
    @Singleton
    fun bindMediaService(
        mediaService: LocalMediaService,
    ): MediaService
}
