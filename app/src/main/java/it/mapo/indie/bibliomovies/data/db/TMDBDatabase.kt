package it.mapo.indie.bibliomovies.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow

@Database(entities = [Movie::class, Artist::class, TvShow::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao():MovieDao
    abstract fun tvShowsDao():TvShowDao
    abstract fun artistDao():ArtistDao
}