package com.a.randomsquare.di

import com.a.randomsquare.ColorsGenerator
import dagger.Module
import dagger.Provides

@Module
class ColorsGeneratorModule {

    @Provides
    fun getColorsGeneratorModule(): ColorsGenerator {
        return ColorsGenerator()
    }
}