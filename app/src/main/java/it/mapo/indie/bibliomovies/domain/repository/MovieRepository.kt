package it.mapo.indie.bibliomovies.domain.repository

import it.mapo.indie.bibliomovies.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}
