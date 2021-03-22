package it.mapo.indie.bibliomovies.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.domain.usecases.GetArtistUseCase
import it.mapo.indie.bibliomovies.domain.usecases.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtists(): LiveData<List<Artist>?> = liveData {
        val artistsList: List<Artist>? = getArtistUseCase.execute()
        emit(artistsList)
    }


    fun updateArtists(): LiveData<List<Artist>?> = liveData {
        val artistsList: List<Artist>? = updateArtistsUseCase.execute()
        emit(artistsList)
    }
}