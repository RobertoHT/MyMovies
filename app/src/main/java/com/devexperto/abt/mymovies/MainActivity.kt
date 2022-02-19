package com.devexperto.abt.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.devexperto.abt.mymovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = MoviesAdapter(listOf(
            Movie("Title 1", "https://loremflickr.com/320/240?lock=1"),
            Movie("Title 2", "https://loremflickr.com/320/240?lock=2"),
            Movie("Title 3", "https://loremflickr.com/320/240?lock=3"),
            Movie("Title 4", "https://loremflickr.com/320/240?lock=4")
        )) {
            movie -> Toast.makeText(this@MainActivity, movie.title, Toast.LENGTH_SHORT).show()
        }
    }
}