package it.mapo.indie.bibliomovies.domain.repository

import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow

interface TvShowRepository {
        suspend fun getTvShows(): List<TvShow>?
        suspend fun updateTvShows(): List<TvShow>?
}