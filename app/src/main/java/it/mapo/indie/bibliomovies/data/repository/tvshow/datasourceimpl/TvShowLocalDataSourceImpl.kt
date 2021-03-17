package it.mapo.indie.bibliomovies.data.repository.tvshow.datasourceimpl

import it.mapo.indie.bibliomovies.data.db.TvShowDao
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource{
    override suspend fun getTvShowsFromDb(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDb(tvShows: List<TvShow>) {
        CoroutineScope(IO).launch {
            tvShowDao.saveTvShow(tvShows)
        }
    }

    override suspend fun clearAllTvShowsFromDB() {
        CoroutineScope(IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}