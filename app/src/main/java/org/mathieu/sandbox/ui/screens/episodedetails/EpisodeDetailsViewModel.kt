package org.mathieu.sandbox.ui.screens.episodedetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.mathieu.sandbox.data.CharacterRepositoryImpl
import org.mathieu.sandbox.data.EpisodeRepositoryImpl
import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.ui.screens.characterdetails.CharacterDetailsState

class EpisodeDetailsViewModel (application: Application) : AndroidViewModel(application){
    private val _state: MutableStateFlow<EpisodeDetailsState> = MutableStateFlow(
        EpisodeDetailsState()
    )

    val state: StateFlow<EpisodeDetailsState>
        get() = _state

    fun initialize(id: Int) {
        val episode = EpisodeRepositoryImpl.getEpisodeByIdOrNull(id)!!

        _state.value = EpisodeDetailsState(
            date = episode.date,
            name = episode.name
        )

    }

}

data class EpisodeDetailsState(
    val date: String = "",
    val name: String = ""
)