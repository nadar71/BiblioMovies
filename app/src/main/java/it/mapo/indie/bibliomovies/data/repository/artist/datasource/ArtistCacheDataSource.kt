package it.mapo.indie.bibliomovies.data.repository.artist.datasource

import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artists: List<Artist>)
    suspend fun clearAllArtistFromCache()
}