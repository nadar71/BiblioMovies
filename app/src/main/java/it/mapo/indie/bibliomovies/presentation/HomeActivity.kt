package it.mapo.indie.bibliomovies.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.mapo.indie.bibliomovies.databinding.ActivityHomeBinding
import it.mapo.indie.bibliomovies.presentation.artist.ArtistActivity
import it.mapo.indie.bibliomovies.presentation.movie.MovieActivity
import it.mapo.indie.bibliomovies.presentation.tv.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.movieButton.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }

        binding.artistsButton.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }

        binding.tvButton.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }
    }
}