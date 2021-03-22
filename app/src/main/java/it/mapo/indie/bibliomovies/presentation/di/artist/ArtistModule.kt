package it.mapo.indie.bibliomovies.presentation.di.artist

import dagger.Module
import dagger.Provides
import it.mapo.indie.bibliomovies.domain.usecases.GetArtistUseCase
import it.mapo.indie.bibliomovies.domain.usecases.UpdateArtistsUseCase
import it.mapo.indie.bibliomovies.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun ArtistViewModelFactory(
            getArtistUseCase: GetArtistUseCase,
            updateArtistsUseCase: UpdateArtistsUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase, updateArtistsUseCase)
    }
}