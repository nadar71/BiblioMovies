package it.mapo.indie.bibliomovies.presentation.di.tvshow

import dagger.Subcomponent
import it.mapo.indie.bibliomovies.presentation.artist.ArtistActivity
import it.mapo.indie.bibliomovies.presentation.tv.TvShowActivity
import javax.inject.Scope


@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject (tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}