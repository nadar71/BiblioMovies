package it.mapo.indie.bibliomovies.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import it.mapo.indie.bibliomovies.domain.usecases.GetMoviesUseCase
import it.mapo.indie.bibliomovies.domain.usecases.UpdateMoviesUseCase

class MovieViewModelFactory(
        private val getMoviesUseCase: GetMoviesUseCase,
        private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase,updateMoviesUseCase) as T
    }
}