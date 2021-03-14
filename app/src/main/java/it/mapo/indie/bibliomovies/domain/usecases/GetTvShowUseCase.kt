package it.mapo.indie.bibliomovies.domain.usecases

import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow
import it.mapo.indie.bibliomovies.domain.repository.TVShowRepository

class GetTvShowUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}