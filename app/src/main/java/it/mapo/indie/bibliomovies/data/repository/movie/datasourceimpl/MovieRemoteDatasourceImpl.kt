package it.mapo.indie.bibliomovies.data.repository.movie.datasourceimpl

import it.mapo.indie.bibliomovies.data.api.TMDBService
import it.mapo.indie.bibliomovies.data.model.movie.MovieList
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ): MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}