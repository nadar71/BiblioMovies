package it.mapo.indie.bibliomovies.data.api

import it.mapo.indie.bibliomovies.data.model.artist.ArtistList
import it.mapo.indie.bibliomovies.data.model.movie.MovieList
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        )apiKey: String
    ): Response<MovieList>


    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query(
            "api_key"
        )apiKey: String
    ): Response<TvShowList>


    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query(
            "api_key"
        )apiKey: String
    ): Response<ArtistList>
}