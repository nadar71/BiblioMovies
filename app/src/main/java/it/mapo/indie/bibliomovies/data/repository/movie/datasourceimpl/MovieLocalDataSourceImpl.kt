package it.mapo.indie.bibliomovies.data.repository.movie.datasourceimpl

import it.mapo.indie.bibliomovies.data.db.MovieDao
import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDb(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMoviesToDb(movies: List<Movie>) {
        CoroutineScope(IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAllMoviesFromDB() {
        CoroutineScope(IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}