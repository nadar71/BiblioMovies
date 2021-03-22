package it.mapo.indie.bibliomovies.presentation.di.movie

import dagger.Subcomponent
import it.mapo.indie.bibliomovies.presentation.artist.ArtistActivity
import it.mapo.indie.bibliomovies.presentation.movie.MovieActivity
import javax.inject.Scope


@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject (movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}