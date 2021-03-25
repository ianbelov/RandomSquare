package com.a.randomsquare.common

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {

    @Singleton
    @Provides
    fun context(appInstance: Application): Context = appInstance.applicationContext
}