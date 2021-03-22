package it.mapo.indie.bibliomovies.presentation.di.core

import dagger.Component
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow
import it.mapo.indie.bibliomovies.presentation.di.artist.ArtistSubComponent
import it.mapo.indie.bibliomovies.presentation.di.movie.MovieSubComponent
import it.mapo.indie.bibliomovies.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DbModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCasesModule::class
])
interface AppComponent {
    fun movieSubComponent():  MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvshowSubComponent(): TvShowSubComponent.Factory
}