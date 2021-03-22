package it.mapo.indie.bibliomovies.presentation.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import it.mapo.indie.bibliomovies.data.model.tvshow.TvShow
import it.mapo.indie.bibliomovies.domain.usecases.GetTvShowUseCase
import it.mapo.indie.bibliomovies.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows(): LiveData<List<TvShow>?> = liveData {
        val tvShowsList: List<TvShow>? = getTvShowUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTvShows(): LiveData<List<TvShow>?> = liveData {
        val tvShowsList: List<TvShow>? = updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }
}