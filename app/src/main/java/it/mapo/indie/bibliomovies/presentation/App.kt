package it.mapo.indie.bibliomovies.presentation

import android.app.Application
import it.mapo.indie.bibliomovies.BuildConfig
import it.mapo.indie.bibliomovies.presentation.di.Injector
import it.mapo.indie.bibliomovies.presentation.di.artist.ArtistSubComponent
import it.mapo.indie.bibliomovies.presentation.di.core.*
import it.mapo.indie.bibliomovies.presentation.di.movie.MovieSubComponent
import it.mapo.indie.bibliomovies.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .netModule(NetModule(BuildConfig.BASE_URL))
                .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
                .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvshowSubComponent(): TvShowSubComponent {
        return appComponent.tvshowSubComponent().create()
    }
}