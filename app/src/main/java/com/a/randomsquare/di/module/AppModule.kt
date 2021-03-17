package com.a.randomsquare.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private var context: Context) {

    @Singleton
    @Provides
    fun getContext(): Context {
        return context
    }

//    @ContributesAndroidInjector
//    fun getMainFragment(): MainFragment{
//
//    }
}