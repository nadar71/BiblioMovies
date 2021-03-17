package it.mapo.indie.bibliomovies.data.repository.artist.datasource

import it.mapo.indie.bibliomovies.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}