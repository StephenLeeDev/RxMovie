package com.example.rxmovie.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxmovie.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val movieList = MutableLiveData<List<MovieModel>>()

    fun getMovieList() =
        Repository.movieService()
            .getAllMovies()
            .subscribeOn(Schedulers.io())
            .subscribe { movies ->
                movieList.postValue(movies)
            }
}