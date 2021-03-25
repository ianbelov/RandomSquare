package com.a.randomsquare.second

import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.ViewModelKey
import com.a.randomsquare.util.colornamegenerator.ColorNameGeneratorImpl
import com.a.randomsquare.util.colornamegenerator.IColorNameGenerator
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SecondFragmentModule {

    @Binds
    abstract fun provideSecondColorsGenerator(generator: ColorNameGeneratorImpl): IColorNameGenerator

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    internal abstract fun secondViewModel(viewModel: SecondViewModel): ViewModel
}