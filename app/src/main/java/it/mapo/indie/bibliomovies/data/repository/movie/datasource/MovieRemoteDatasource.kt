package it.mapo.indie.bibliomovies.data.repository.movie.datasource

import it.mapo.indie.bibliomovies.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}