package com.example.dependencyinjectionkoin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Logging Koin data with debug
            androidLogger(Level.DEBUG)

            // Application context that will be used by Koin dependencies
            androidContext(this@App)

            // Defining modules
            modules(mainModule)
        }
    }
}