package it.mapo.indie.bibliomovies.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import it.mapo.indie.bibliomovies.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(tvShows: List<Artist>)

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists():List<Artist>

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()
}