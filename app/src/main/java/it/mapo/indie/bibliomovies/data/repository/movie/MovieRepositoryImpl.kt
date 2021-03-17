package it.mapo.indie.bibliomovies.data.repository.movie

import android.content.ContentValues.TAG
import android.util.Log
import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.data.model.movie.MovieList
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieCacheDataSource
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieLocalDataSource
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieRemoteDatasource
import it.mapo.indie.bibliomovies.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
    ): MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAllMoviesFromDB()
        movieLocalDataSource.saveMoviesToDb(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            val response = movieRemoteDatasource.getMovies()
            val body: MovieList? = response.body()
            if (body != null){
                movieList = body.movies
            }
        }catch(exception: Exception){
            Log.i(TAG, "getMoviesFromApi: ${exception.message.toString()} ")
        }
        return movieList
    }


    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            movieList = movieLocalDataSource.getMoviesFromDb()
        }catch(exception: Exception){
            Log.i(TAG, "getMoviesFromDB: ${exception.message.toString()} ")
        }

        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDb(movieList)
        }
        return movieList
    }


    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch(exception: Exception){
            Log.i(TAG, "getMoviesFromCache: ${exception.message.toString()} ")
        }

        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}