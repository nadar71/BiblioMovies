package it.mapo.indie.bibliomovies.data.repository.tvshow.datasource

import it.mapo.indie.bibliomovies.data.model.movie.MovieList
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}