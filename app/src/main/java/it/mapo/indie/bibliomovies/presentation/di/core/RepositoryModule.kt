package it.mapo.indie.bibliomovies.presentation.di.core

import dagger.Module
import dagger.Provides
import it.mapo.indie.bibliomovies.data.repository.artist.ArtistRepositoryImpl
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistCacheDataSource
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistLocalDataSource
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistRemoteDatasource
import it.mapo.indie.bibliomovies.data.repository.movie.MovieRepositoryImpl
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieCacheDataSource
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieLocalDataSource
import it.mapo.indie.bibliomovies.data.repository.movie.datasource.MovieRemoteDatasource
import it.mapo.indie.bibliomovies.data.repository.tvshow.TvShowRepositoryImpl
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowCacheDataSource
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowLocalDataSource
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowRemoteDatasource
import it.mapo.indie.bibliomovies.domain.repository.ArtistRepository
import it.mapo.indie.bibliomovies.domain.repository.MovieRepository
import it.mapo.indie.bibliomovies.domain.repository.TvShowRepository
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
            movieRemoteDatasource: MovieRemoteDatasource,
            movieCacheDataSource: MovieCacheDataSource,
            movieLocalDataSource: MovieLocalDataSource
    ): MovieRepository{
        return MovieRepositoryImpl(
                movieRemoteDatasource,
                movieCacheDataSource,
                movieLocalDataSource,
        )
    }



    @Singleton
    @Provides
    fun providesArtistRepository(
            artistRemoteDatasource: ArtistRemoteDatasource,
            artistCacheDataSource: ArtistCacheDataSource,
            artistLocalDataSource: ArtistLocalDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
                artistCacheDataSource,
                artistLocalDataSource,
                artistRemoteDatasource,
        )
    }


    @Singleton
    @Provides
    fun providesTvShowRepository(
            tvShowRemoteDatasource: TvShowRemoteDatasource,
            tvShowCacheDataSource: TvShowCacheDataSource,
            tvShowLocalDataSource: TvShowLocalDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
                tvShowCacheDataSource,
                tvShowLocalDataSource,
                tvShowRemoteDatasource,
        )
    }
}