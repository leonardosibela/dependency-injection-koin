package com.example.dependencyinjectionkoin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.moviesEvent.observe(this, Observer { movies ->
            textViewMovies.text = movies.map {
                "\n${it.id} - ${it.title}\n"
            }.toString()
        })

        viewModel.getMoviesCoroutines()
    }
}