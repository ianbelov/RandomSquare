package com.a.randomsquare.second

import androidx.lifecycle.ViewModel
import com.a.randomsquare.generator.colorgenerator.IColorsGenerator
import com.a.randomsquare.generator.colorgenerator.SecondColorsGeneratorImpl
import com.a.randomsquare.common.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SecondFragmentModule {

    @Binds
    abstract fun provideSecondColorsGenerator(generator: SecondColorsGeneratorImpl): IColorsGenerator

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    internal abstract fun secondViewModel(viewModel: SecondViewModel): ViewModel

}