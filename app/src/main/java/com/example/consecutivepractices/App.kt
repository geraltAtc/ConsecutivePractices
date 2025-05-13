package com.example.consecutivepractices

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.consecutivepractices.module.dataModule
import com.example.consecutivepractices.module.restModule
import com.example.consecutivepractices.module.rootModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(rootModule, restModule, dataModule)
        }
    }
}