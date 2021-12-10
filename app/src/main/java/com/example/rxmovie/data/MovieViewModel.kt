package com.example.rxmovie.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxmovie.network.Repository
import io.reactivex.schedulers.Schedulers

class MovieViewModel : ViewModel() {
    val movieList = MutableLiveData<List<MovieModel>>()

    fun getMovieList() =
        Repository.movieService
            .getMovies()
            .subscribeOn(Schedulers.io())
            .subscribe { movies ->
                movieList.postValue(movies)
            }
}