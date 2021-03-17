package com.a.randomsquare

import com.a.randomsquare.di.component.DaggerAppComponent
import com.a.randomsquare.di.module.ContextModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
    private val applicationInjector = DaggerAppComponent.builder().application(this).build()
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}