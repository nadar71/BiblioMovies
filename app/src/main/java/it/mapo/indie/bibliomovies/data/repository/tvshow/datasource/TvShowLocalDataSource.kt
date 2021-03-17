package it.mapo.indie.bibliomovies.data.repository.tvshow.datasource

import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDb(): List<TvShow>
    suspend fun saveTvShowsToDb(tvShows: List<TvShow>)
    suspend fun clearAllTvShowsFromDB()
}