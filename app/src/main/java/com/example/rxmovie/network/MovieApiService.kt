package com.example.rxmovie.network

import com.example.rxmovie.data.MovieModel
import io.reactivex.Single
import retrofit2.http.GET

interface MovieApiService {

    @GET("movielist.json")
    fun getMovies(): Single<List<MovieModel>>

}