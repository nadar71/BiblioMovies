package it.mapo.indie.bibliomovies.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import it.mapo.indie.bibliomovies.domain.usecases.GetMoviesUseCases
import it.mapo.indie.bibliomovies.domain.usecases.UpdateMoviesUseCases

class MovieViewModelFactory(
    private val getMoviesUseCases: GetMoviesUseCases,
    private val updateMoviesUseCases: UpdateMoviesUseCases
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCases,updateMoviesUseCases) as T
    }
}