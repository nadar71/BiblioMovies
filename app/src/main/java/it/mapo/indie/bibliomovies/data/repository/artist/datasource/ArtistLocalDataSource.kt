package it.mapo.indie.bibliomovies.data.repository.artist.datasource

import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistFromDb(): List<Artist>
    suspend fun saveArtistToDb(artists: List<Artist>)
    suspend fun clearAllArtistFromDB()
}