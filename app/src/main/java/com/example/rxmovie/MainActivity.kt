package com.example.rxmovie

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.rxmovie.adapter.MovieAdapter
import com.example.rxmovie.data.MovieViewModel
import com.example.rxmovie.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val movieViewModel: MovieViewModel by viewModels()
    @Inject lateinit var adapter: MovieAdapter
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
        bindData()
    }

    private fun initRecyclerView() {
        adapter = MovieAdapter()
        binding.recyclerview.adapter = adapter
    }

    private fun bindData() {
        movieViewModel.movieList.observe(this) { movies ->
            adapter.submitList(movies)
        }
        movieViewModel.getMovieList()
    }
}