package com.a.randomsquare

import android.app.Application
import com.a.randomsquare.di.component.AppComponent
import com.a.randomsquare.di.module.AppModule
import com.a.randomsquare.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    companion object {
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        setUp()
    }

    private fun setUp() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

}