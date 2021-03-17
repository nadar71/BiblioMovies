package it.mapo.indie.bibliomovies.data.repository.tvshow.datasource

import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
    suspend fun clearAllTvShowsFromCache()
}