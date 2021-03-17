package it.mapo.indie.bibliomovies.data.repository.artist.datasourceimpl

import it.mapo.indie.bibliomovies.data.api.TMDBService
import it.mapo.indie.bibliomovies.data.model.artist.ArtistList
import it.mapo.indie.bibliomovies.data.model.movie.MovieList
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String
    ):ArtistRemoteDatasource {

    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}