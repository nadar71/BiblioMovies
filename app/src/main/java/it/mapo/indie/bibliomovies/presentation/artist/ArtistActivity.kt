package it.mapo.indie.bibliomovies.presentation.artist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.mapo.indie.bibliomovies.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}