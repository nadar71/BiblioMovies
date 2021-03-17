package it.mapo.indie.bibliomovies.data.repository.tvshow.datasourceimpl

import it.mapo.indie.bibliomovies.data.api.TMDBService
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShowList
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String
    ): TvShowRemoteDatasource {

    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}