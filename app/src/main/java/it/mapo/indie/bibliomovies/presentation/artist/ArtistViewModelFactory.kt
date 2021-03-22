package it.mapo.indie.bibliomovies.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import it.mapo.indie.bibliomovies.domain.usecases.GetArtistUseCase
import it.mapo.indie.bibliomovies.domain.usecases.UpdateArtistsUseCase

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase, updateArtistsUseCase) as T
    }
}