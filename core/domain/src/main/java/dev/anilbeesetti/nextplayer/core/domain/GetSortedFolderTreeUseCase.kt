package app.uvteam.afnplayer.core.domain

import app.uvteam.afnplayer.core.common.Dispatcher
import app.uvteam.afnplayer.core.common.NextDispatchers
import app.uvteam.afnplayer.core.data.repository.MediaRepository
import app.uvteam.afnplayer.core.data.repository.PreferencesRepository
import app.uvteam.afnplayer.core.model.ApplicationPreferences
import app.uvteam.afnplayer.core.model.Folder
import app.uvteam.afnplayer.core.model.Sort
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn

class GetSortedFolderTreeUseCase @Inject constructor(
    private val mediaRepository: MediaRepository,
    private val preferencesRepository: PreferencesRepository,
    @Dispatcher(NextDispatchers.Default) private val defaultDispatcher: CoroutineDispatcher,
) {
    operator fun invoke(folderPath: String? = null): Flow<Folder?> = combine(
        mediaRepository.getFoldersFlow(),
        preferencesRepository.applicationPreferences,
    ) { folders, preferences ->
        val currentFolder = folderPath?.let {
            folders.find { it.path == folderPath } ?: return@combine null
        } ?: Folder.rootFolder

        val sort = Sort(by = preferences.sortBy, order = preferences.sortOrder)

        currentFolder.copy(
            folderList = folders.getFoldersFor(path = currentFolder.path, preferences = preferences),
        ).let { folder ->
            if (folderPath == null) folder.getInitialFolderWithContent() else folder
        }.let { folder ->
            folder.copy(
                mediaList = folder.mediaList.sortedWith(sort.videoComparator()),
                folderList = folder.folderList.sortedWith(sort.folderComparator()),
            )
        }
    }.flowOn(defaultDispatcher)

    private fun Folder.getInitialFolderWithContent(): Folder {
        return when {
            mediaList.isEmpty() && folderList.size == 1 -> folderList.first().getInitialFolderWithContent()
            else -> this
        }
    }

    private fun List<Folder>.getFoldersFor(
        path: String,
        preferences: ApplicationPreferences,
    ): List<Folder> {
        return filter {
            it.parentPath == path && it.path !in preferences.excludeFolders
        }.map { directory ->
            Folder(
                name = directory.name,
                path = directory.path,
                dateModified = directory.dateModified,
                mediaList = directory.mediaList,
                folderList = getFoldersFor(path = directory.path, preferences = preferences),
            )
        }
    }
}
