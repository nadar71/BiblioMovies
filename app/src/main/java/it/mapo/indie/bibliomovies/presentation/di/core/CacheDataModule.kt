package it.mapo.indie.bibliomovies.presentation.di.core

import dagger.Module
import dagger.Provides
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistCacheDataSource
import it.mapo.indie.bibliomovies.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieCacheDataSource
import it.mapo.indie.bibliomovies.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowCacheDataSource
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }
}