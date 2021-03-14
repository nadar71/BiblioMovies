package it.mapo.indie.bibliomovies.domain.repository

import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow

interface ArtistRepository {
        suspend fun getArtists(): List<Artist>?
        suspend fun updateArtists(): List<Artist>?
}