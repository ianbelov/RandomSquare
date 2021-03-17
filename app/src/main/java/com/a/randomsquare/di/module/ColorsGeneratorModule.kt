package com.a.randomsquare.di.module

import android.content.Context
import com.a.randomsquare.ColorsGenerator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ColorsGeneratorModule {

    @Singleton
    @Provides
    fun getColorsGeneratorModule(context: Context): ColorsGenerator {
        return ColorsGenerator(context)
    }
}