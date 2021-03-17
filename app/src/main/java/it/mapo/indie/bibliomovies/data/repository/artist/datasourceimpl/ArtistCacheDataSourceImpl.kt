package it.mapo.indie.bibliomovies.data.repository.artist.datasourceimpl

import it.mapo.indie.bibliomovies.data.model.artist.Artist
import it.mapo.indie.bibliomovies.data.model.movie.Movie
import it.mapo.indie.bibliomovies.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> = artistList
    override suspend fun saveArtistToCache(artists: List<Artist>){
        artistList.clear()
        artistList = ArrayList(artists)
    }
    override suspend fun clearAllArtistFromCache(){
        artistList.clear()
    }
}