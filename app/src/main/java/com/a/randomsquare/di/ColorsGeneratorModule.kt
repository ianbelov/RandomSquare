package com.a.randomsquare.di

import android.content.Context
import com.a.randomsquare.ColorsGenerator
import dagger.Module
import dagger.Provides

@Module
class ColorsGeneratorModule {

    @Provides
    fun getColorsGeneratorModule(context: Context): ColorsGenerator {
        return ColorsGenerator(context)
    }
}