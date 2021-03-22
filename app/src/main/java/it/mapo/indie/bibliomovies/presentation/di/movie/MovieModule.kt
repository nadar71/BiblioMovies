package it.mapo.indie.bibliomovies.presentation.di.movie

import dagger.Module
import dagger.Provides
import it.mapo.indie.bibliomovies.domain.usecases.GetMoviesUseCase
import it.mapo.indie.bibliomovies.domain.usecases.UpdateMoviesUseCase
import it.mapo.indie.bibliomovies.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun MovieViewModelFactory(
            getMoviesUseCase: GetMoviesUseCase,
            updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}