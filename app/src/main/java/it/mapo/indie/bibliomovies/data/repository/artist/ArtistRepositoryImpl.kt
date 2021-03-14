package it.mapo.indie.bibliomovies.data.repository.artist

import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.domain.repository.ArtistRepository

class ArtistRepositoryImpl: ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtists(): List<Artist>? {
        TODO("Not yet implemented")
    }
}