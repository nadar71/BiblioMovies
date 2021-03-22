package it.mapo.indie.bibliomovies.data.repository.tvshow

import android.content.ContentValues.TAG
import android.util.Log
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShowList
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowCacheDataSource
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowLocalDataSource
import it.mapo.indie.bibliomovies.data.repository.tvshow.datasource.TvShowRemoteDatasource
import it.mapo.indie.bibliomovies.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowCacheDataSource: TvShowCacheDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowRemoteDatasource: TvShowRemoteDatasource
): TvShowRepository {

    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newTvShowslist = getTvShowsFromApi()
        tvShowLocalDataSource.clearAllTvShowsFromDB()
        tvShowLocalDataSource.saveTvShowsToDb(newTvShowslist)
        tvShowCacheDataSource.saveTvShowsToCache(newTvShowslist)
        return newTvShowslist
    }


    suspend fun getTvShowsFromApi(): List<TvShow>{
        lateinit var tvShowsList: List<TvShow>
        try {
            var response = tvShowRemoteDatasource.getTvShows()
            var body: TvShowList? = response.body()
            if (body != null){
                tvShowsList = body.tvShows
            }
        } catch (exception: Exception){
            Log.i(TAG, "getTvShowsFromApi: ${exception.message.toString()}")
        }
        return tvShowsList
    }



    suspend fun getTvShowsFromDb(): List<TvShow>{
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowLocalDataSource.getTvShowsFromDb()
        } catch (exception: Exception){
            Log.i(TAG, "getTvShowsFromDb: ${exception.message.toString()}")
        }

        if(tvShowsList.size > 0){
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDb(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowsList: List<TvShow>
        try {
            tvShowsList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception: Exception){
            Log.i(TAG, "getTvShowsFromCache: ${exception.message.toString()}")
        }

        if(tvShowsList.size > 0){
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromDb()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        }
        return tvShowsList

    }
}