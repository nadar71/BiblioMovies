package it.mapo.indie.bibliomovies.presentation.di.core

import dagger.Module
import dagger.Provides
import it.mapo.indie.bibliomovies.data.api.TMDBService
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistRemoteDatasource
import it.mapo.indie.bibliomovies.data.repository.artist.datasourceimpl.ArtistRemoteDatasourceImpl
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieRemoteDatasource
import it.mapo.indie.bibliomovies.data.repository.movie.datasourceimpl.MovieRemoteDatasourceImpl
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowRemoteDatasource
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasourceimpl.TvShowRemoteDatasourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService ): MovieRemoteDatasource{
        return MovieRemoteDatasourceImpl(tmdbService, apiKey)
    }


    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService ): ArtistRemoteDatasource{
        return ArtistRemoteDatasourceImpl(tmdbService, apiKey)
    }


    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService ): TvShowRemoteDatasource {
        return TvShowRemoteDatasourceImpl(tmdbService, apiKey)
    }
}