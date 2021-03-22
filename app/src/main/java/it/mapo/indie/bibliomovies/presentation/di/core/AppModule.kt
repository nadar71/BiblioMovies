package it.mapo.indie.bibliomovies.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import it.mapo.indie.bibliomovies.presentation.di.artist.ArtistSubComponent
import it.mapo.indie.bibliomovies.presentation.di.movie.MovieSubComponent
import it.mapo.indie.bibliomovies.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton



@Module(subcomponents = [
    MovieSubComponent::class,
    ArtistSubComponent::class,
    TvShowSubComponent::class
])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesApplicationContext(): Context{
        return context.applicationContext
    }
}