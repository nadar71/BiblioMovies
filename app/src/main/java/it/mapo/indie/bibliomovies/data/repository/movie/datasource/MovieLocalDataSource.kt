package it.mapo.indie.bibliomovies.data.repository.movie.datasource

import it.mapo.indie.bibliomovies.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDb(): List<Movie>
    suspend fun saveMoviesToDb(movies: List<Movie>)
    suspend fun clearAllMoviesFromDB()
}