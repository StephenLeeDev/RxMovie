package com.example.rxmovie.network

import com.example.rxmovie.data.MovieModel
import io.reactivex.Observable
import retrofit2.http.GET

interface MovieService {

    @GET("movielist.json")
    fun getMovies(): Observable<List<MovieModel>>

}