package com.mahmoudhamdyae.fridgecompose

import android.app.Application
import com.mahmoudhamdyae.fridgecompose.core.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class FridgeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@FridgeApplication)
            modules(appModule)
        }
    }
}