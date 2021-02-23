package com.example.dependencyinjectionkoin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    // Singleton with application scope
    single {
        MainRepository()
    }

    // Application scope
    factory {

    }

    // ViewModel scope
    viewModel {
        MainViewModel(
            repository = get() // method used to inject a dependency known to Koin
        )
    }
}