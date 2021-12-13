package com.example.rxmovie.network

import com.example.rxmovie.data.MovieModel
import io.reactivex.Observable

interface MainRepository {
    fun getAllMovies(): Observable<List<MovieModel>>
}