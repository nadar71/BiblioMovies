package it.mapo.indie.bibliomovies.presentation.di.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import it.mapo.indie.bibliomovies.data.db.ArtistDao
import it.mapo.indie.bibliomovies.data.db.MovieDao
import it.mapo.indie.bibliomovies.data.db.TMDBDatabase
import it.mapo.indie.bibliomovies.data.db.TvShowDao
import javax.inject.Singleton

@Module
class DbModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }


    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }


    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return tmdbDatabase.artistDao()
    }


    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao{
        return tmdbDatabase.tvShowsDao()
    }
}