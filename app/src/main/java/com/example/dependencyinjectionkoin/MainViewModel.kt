package com.example.dependencyinjectionkoin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val moviesEvent = MutableLiveData<List<Movie>>()

    fun getMoviesCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = withContext(Dispatchers.Default) {
                repository.getMoviesCoroutines()
            }

            moviesEvent.value = movies
        }
    }
}