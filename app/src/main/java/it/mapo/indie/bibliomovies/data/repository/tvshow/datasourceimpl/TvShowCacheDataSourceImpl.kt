package it.mapo.indie.bibliomovies.data.repository.tvshow.datasourceimpl

import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {
    var tvShows =  ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShows
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        this.tvShows = ArrayList(tvShows)
    }

    override suspend fun clearAllTvShowsFromCache() {
        tvShows.clear()
    }
}