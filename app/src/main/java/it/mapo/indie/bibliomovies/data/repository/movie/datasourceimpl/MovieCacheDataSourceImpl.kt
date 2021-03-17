package it.mapo.indie.bibliomovies.data.repository.movie.datasourceimpl

import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movielist = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> = movielist


    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movielist.clear()
        movielist = ArrayList(movies)
    }

    override suspend fun clearAllMoviesFromCache() {
        movielist.clear()
    }
}