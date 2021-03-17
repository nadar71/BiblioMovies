package it.mapo.indie.bibliomovies.presentation.tv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.mapo.indie.bibliomovies.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}