package it.mapo.indie.bibliomovies.presentation.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.mapo.indie.bibliomovies.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}