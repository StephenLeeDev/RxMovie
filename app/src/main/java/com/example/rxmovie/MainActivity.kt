package com.example.rxmovie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.rxmovie.network.Repository
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = Repository.movieApiService.getMovies()
            .subscribeOn(Schedulers.io())
            .subscribe { response ->
                Log.d("movies", response.toString())
            }
    }
}