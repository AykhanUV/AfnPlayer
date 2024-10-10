package app.uvteam.afnplayer.core.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import app.uvteam.afnplayer.core.data.repository.LocalMediaRepository
import app.uvteam.afnplayer.core.data.repository.LocalPreferencesRepository
import app.uvteam.afnplayer.core.data.repository.MediaRepository
import app.uvteam.afnplayer.core.data.repository.PreferencesRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMediaRepository(
        videoRepository: LocalMediaRepository,
    ): MediaRepository

    @Binds
    fun bindsPreferencesRepository(
        preferencesRepository: LocalPreferencesRepository,
    ): PreferencesRepository
}
