package com.a.randomsquare

import android.app.Application
import com.a.randomsquare.di.AppComponent
import com.a.randomsquare.di.ContextModule
import com.a.randomsquare.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        setUpDaggerComponent()
    }

    private fun setUpDaggerComponent() {
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()
    }

}