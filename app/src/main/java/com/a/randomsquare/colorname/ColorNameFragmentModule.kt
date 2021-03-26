package com.a.randomsquare.colorname

import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.ViewModelKey
import com.a.randomsquare.util.colornamegenerator.ColorNameGeneratorImpl
import com.a.randomsquare.util.colornamegenerator.IColorNameGenerator
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ColorNameFragmentModule {

    @Binds
    abstract fun provideSecondColorsGenerator(generator: ColorNameGeneratorImpl): IColorNameGenerator

    @Binds
    @IntoMap
    @ViewModelKey(ColorNameViewModel::class)
    internal abstract fun secondViewModel(viewModel: ColorNameViewModel): ViewModel
}