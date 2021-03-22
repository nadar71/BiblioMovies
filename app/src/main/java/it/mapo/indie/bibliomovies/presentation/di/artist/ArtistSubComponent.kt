package it.mapo.indie.bibliomovies.presentation.di.artist

import dagger.Subcomponent
import it.mapo.indie.bibliomovies.presentation.artist.ArtistActivity
import javax.inject.Scope


@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject (artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}