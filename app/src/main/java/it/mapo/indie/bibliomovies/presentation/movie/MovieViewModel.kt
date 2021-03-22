package it.mapo.indie.bibliomovies.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.domain.usecases.GetMoviesUseCase
import it.mapo.indie.bibliomovies.domain.usecases.UpdateMoviesUseCase

class MovieViewModel(
        private val getMoviesUseCase: GetMoviesUseCase,
        private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies(): LiveData<List<Movie>?> = liveData {
        val movieList: List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun update(): LiveData<List<Movie>?> = liveData {
        val movieList: List<Movie>? = updateMoviesUseCase.execute()
        emit(movieList)
    }
}