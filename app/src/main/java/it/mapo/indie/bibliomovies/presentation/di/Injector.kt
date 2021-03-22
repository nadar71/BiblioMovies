package it.mapo.indie.bibliomovies.presentation.di

import it.mapo.indie.bibliomovies.presentation.di.artist.ArtistSubComponent
import it.mapo.indie.bibliomovies.presentation.di.movie.MovieSubComponent
import it.mapo.indie.bibliomovies.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():  MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvshowSubComponent(): TvShowSubComponent
}