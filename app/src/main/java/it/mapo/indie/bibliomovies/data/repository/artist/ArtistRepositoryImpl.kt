package it.mapo.indie.bibliomovies.data.repository.artist

import android.content.ContentValues.TAG
import android.util.Log
import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.data.model.artist.ArtistList
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistCacheDataSource
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistLocalDataSource
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistRemoteDatasource
import it.mapo.indie.bibliomovies.data.repository.artist.datasourceimpl.ArtistRemoteDatasourceImpl
import it.mapo.indie.bibliomovies.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDatasource: ArtistRemoteDatasource 
): ArtistRepository {
    
    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val newArtistList = getArtistsFromApi()
        artistLocalDataSource.clearAllArtistFromDB()
        artistLocalDataSource.saveArtistToDb(newArtistList)
        artistCacheDataSource.saveArtistToCache(newArtistList)
        return newArtistList
    }
    
    suspend fun getArtistsFromApi(): List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            val response = artistRemoteDatasource.getArtists()
            val body: ArtistList? = response.body()
            if (body != null) {
                artistList = body.artists
            }
        }catch(exception: Exception){
            Log.i(TAG, "getArtistsFromApi: ${exception.message.toString()}", )
        }
        return artistList
    }


    suspend fun getArtistsFromDb(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDb()
        }catch (exception: Exception){
            Log.i(TAG, "getArtistsFromApi: ${exception.message.toString()}", )
        }

        if (artistList.size > 0){
            return artistList
        } else {
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistToDb(artistList)
        }

        return artistList
    }


    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch (exception: Exception){
            Log.i(TAG, "getArtistsFromApi: ${exception.message.toString()}", )
        }

        if (artistList.size > 0){
            return artistList
        } else {
            artistList = getArtistsFromDb()
            artistCacheDataSource.saveArtistToCache(artistList)
        }

        return artistList
    }
}