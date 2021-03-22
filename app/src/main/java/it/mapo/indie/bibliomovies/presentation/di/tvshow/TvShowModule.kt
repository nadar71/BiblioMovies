package it.mapo.indie.bibliomovies.presentation.di.tvshow

import dagger.Module
import dagger.Provides
import it.mapo.indie.bibliomovies.domain.usecases.GetTvShowUseCase
import it.mapo.indie.bibliomovies.domain.usecases.UpdateTvShowsUseCase
import it.mapo.indie.bibliomovies.presentation.tvshow.TvShowViewModelFactory

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun TvShowViewModelFactory(
            getTvShowUseCase: GetTvShowUseCase,
            updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowsUseCase)
    }
}