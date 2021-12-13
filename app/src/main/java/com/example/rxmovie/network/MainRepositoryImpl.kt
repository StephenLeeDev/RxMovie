package com.example.rxmovie.network

import javax.inject.Inject

abstract class MainRepositoryImpl @Inject constructor(private val movieService: MovieService): MainRepository {
    override fun getAllMovies() = movieService.getAllMovies()
}