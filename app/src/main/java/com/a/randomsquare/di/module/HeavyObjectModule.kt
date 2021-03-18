package com.a.randomsquare.di.module

import com.a.randomsquare.util.heavyobjects.HeavyObject
import dagger.Module
import dagger.Provides

@Module
class HeavyObjectModule {

    @Provides
    fun provideHeavyObject() = HeavyObject()

}