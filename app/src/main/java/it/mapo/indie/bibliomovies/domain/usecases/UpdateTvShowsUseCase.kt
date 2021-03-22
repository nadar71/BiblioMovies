package it.mapo.indie.bibliomovies.domain.usecases

import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow
import it.mapo.indie.bibliomovies.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}