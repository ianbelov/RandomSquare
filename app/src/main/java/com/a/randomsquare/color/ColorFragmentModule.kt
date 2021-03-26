package com.a.randomsquare.color

import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.ViewModelKey
import com.a.randomsquare.util.colorcodegenerator.IColorsGenerator
import com.a.randomsquare.util.colorcodegenerator.SecondColorsGeneratorImpl
import com.a.randomsquare.util.colornamegenerator.ColorNameGeneratorImpl
import com.a.randomsquare.util.colornamegenerator.IColorNameGenerator
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ColorFragmentModule {

    @Binds
    abstract fun provideFirstColorsGenerator(generator: SecondColorsGeneratorImpl): IColorsGenerator

    @Binds
    abstract fun provideNameGenerator(generator: ColorNameGeneratorImpl): IColorNameGenerator

    @Binds
    @IntoMap
    @ViewModelKey(ColorViewModel::class)
    internal abstract fun firstViewModel(viewModel: ColorViewModel): ViewModel
}