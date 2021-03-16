package com.a.randomsquare.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private var context: Context) {

    @Singleton
    @Provides
    fun getContext(): Context {
        return context
    }
}