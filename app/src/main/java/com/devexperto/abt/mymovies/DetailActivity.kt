package com.devexperto.abt.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.devexperto.abt.mymovies.databinding.ActivityDetailBinding
import com.devexperto.abt.mymovies.model.Movie

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "DetailActivity:movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        if (movie != null) {
            title = movie.title
            Glide.with(binding.root.context).load("https://image.tmdb.org/t/p/w780/${movie.backdropPath}").into(binding.backdrop)
            binding.summary.text = movie.overview
            bindDetailInfo(binding.detailinfo, movie)
        }
    }

    private fun bindDetailInfo(detailinfo: TextView, movie: Movie) {
        detailinfo.text = buildSpannedString {
            bold { append("Original language: ") }
            appendLine(movie.originalLanguage)

            bold { append("Original title: ") }
            appendLine(movie.originalTitle)

            bold { append("Release date: ") }
            appendLine(movie.releaseDate)

            bold { append("Populirity: ") }
            appendLine(movie.popularity.toString())

            bold { append("Vote average: ") }
            appendLine(movie.voteAverage.toString())
        }
    }
}