package it.mapo.indie.bibliomovies.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShows: List<TvShow>)

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getTvShows():List<TvShow>

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllTvShows()
}