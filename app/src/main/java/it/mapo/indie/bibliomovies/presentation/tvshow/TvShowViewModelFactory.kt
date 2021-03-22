package it.mapo.indie.bibliomovies.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import it.mapo.indie.bibliomovies.domain.usecases.GetTvShowUseCase
import it.mapo.indie.bibliomovies.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowsUseCase) as T
    }
}