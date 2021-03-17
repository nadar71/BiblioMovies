package it.mapo.indie.bibliomovies.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.domain.usecases.GetMoviesUseCases
import it.mapo.indie.bibliomovies.domain.usecases.UpdateMoviesUseCases

class MovieViewModel(
    private val getMoviesUseCases: GetMoviesUseCases,
    private val updateMoviesUseCases: UpdateMoviesUseCases
): ViewModel() {

    fun getMovies(): LiveData<List<Movie>?> = liveData {
        val movieList: List<Movie>? = getMoviesUseCases.execute()
        emit(movieList)
    }

    fun update(): LiveData<List<Movie>?> = liveData {
        val movieList: List<Movie>? = updateMoviesUseCases.execute()
        emit(movieList)
    }
}