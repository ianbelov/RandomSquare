package com.a.randomsquare.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(context: Context) {

    private var mainFragmentContext: Context = context

    @Singleton
    @Provides
    fun getContext(): Context {
        return mainFragmentContext
    }
}