package it.mapo.indie.bibliomovies.data.model.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_tvshows")
data class TvShow(
    val first_air_date: String,
    @PrimaryKey
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String,
)