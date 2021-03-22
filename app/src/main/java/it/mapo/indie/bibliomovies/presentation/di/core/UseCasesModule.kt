package it.mapo.indie.bibliomovies.presentation.di.core

import dagger.Module
import dagger.Provides
import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow
import it.mapo.indie.bibliomovies.domain.repository.ArtistRepository
import it.mapo.indie.bibliomovies.domain.repository.MovieRepository
import it.mapo.indie.bibliomovies.domain.repository.TvShowRepository
import it.mapo.indie.bibliomovies.domain.usecases.*

@Module
class UseCasesModule {
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase {
        return GetTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TvShowRepository):UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

}