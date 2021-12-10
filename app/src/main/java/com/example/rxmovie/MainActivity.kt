package com.example.rxmovie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.rxmovie.data.MovieViewModel
import com.example.rxmovie.data.MovieViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieViewModel = ViewModelProvider(this, MovieViewModelFactory()).get(MovieViewModel::class.java)
        movieViewModel.movieList.observe(this) {
            Log.d("movies", it.toString())
        }
        movieViewModel.getMovieList()
    }
}