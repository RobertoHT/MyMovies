package com.devexperto.abt.mymovies.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.devexperto.abt.mymovies.R
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

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        if (movie != null) {
            title = movie.title
            Glide.with(binding.root.context).load("https://image.tmdb.org/t/p/w780/${movie.backdropPath}").into(binding.backdrop)
            binding.summary.text = movie.overview
            bindDetailInfo(binding.detailinfo, movie)

            binding.fab.setOnClickListener {
                //Instrucciones del button
            }
        }
    }

    private fun bindDetailInfo(detailinfo: TextView, movie: Movie) {
        detailinfo.text = buildSpannedString {
            appendInfo(R.string.original_language, movie.originalLanguage)
            appendInfo(R.string.original_title, movie.originalTitle)
            appendInfo(R.string.release_date, movie.releaseDate)
            appendInfo(R.string.popularity, movie.popularity.toString())
            appendInfo(R.string.vote_average, movie.voteAverage.toString())
        }
    }

    private fun SpannableStringBuilder.appendInfo(stringRes: Int, value: String) {
        bold {
            append(getString(stringRes))
            append(": ")
        }
        appendLine(value)
    }
}