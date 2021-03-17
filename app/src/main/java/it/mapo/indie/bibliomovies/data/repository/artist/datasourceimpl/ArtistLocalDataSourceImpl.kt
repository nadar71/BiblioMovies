package it.mapo.indie.bibliomovies.data.repository.artist.datasourceimpl

import it.mapo.indie.bibliomovies.data.db.ArtistDao
import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistFromDb(): List<Artist> = artistDao.getArtists()

    override suspend fun saveArtistToDb(artists: List<Artist>) {
        CoroutineScope(IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAllArtistFromDB() {
        CoroutineScope(IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}