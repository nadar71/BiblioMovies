package it.mapo.indie.bibliomovies.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies():List<Movie>

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()
}