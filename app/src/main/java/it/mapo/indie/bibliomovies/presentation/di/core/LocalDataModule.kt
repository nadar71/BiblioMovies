package it.mapo.indie.bibliomovies.presentation.di.core

import dagger.Module
import dagger.Provides
import it.mapo.indie.bibliomovies.data.db.ArtistDao
import it.mapo.indie.bibliomovies.data.db.MovieDao
import it.mapo.indie.bibliomovies.data.db.TvShowDao
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistLocalDataSource
import it.mapo.indie.bibliomovies.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieLocalDataSource
import it.mapo.indie.bibliomovies.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowLocalDataSource
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao ): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao ): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}