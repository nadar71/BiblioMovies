package it.mapo.indie.bibliomovies.data.repository.movie.datasource

import it.mapo.indie.bibliomovies.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
    suspend fun clearAllMoviesFromCache()
}