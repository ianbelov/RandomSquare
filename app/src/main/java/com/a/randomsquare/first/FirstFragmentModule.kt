package com.a.randomsquare.first

import androidx.lifecycle.ViewModel
import com.a.randomsquare.generator.colorcodegenerator.IColorsGenerator
import com.a.randomsquare.generator.colornamegenerator.INameGenerator
import com.a.randomsquare.generator.colornamegenerator.NameGeneratorImpl
import com.a.randomsquare.generator.colorcodegenerator.SecondColorsGeneratorImpl
import com.a.randomsquare.common.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FirstFragmentModule {

    @Binds
    abstract fun provideFirstColorsGenerator(generator: SecondColorsGeneratorImpl): IColorsGenerator

    @Binds
    abstract fun provideNameGenerator(generator: NameGeneratorImpl): INameGenerator

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    internal abstract fun firstViewModel(viewModel: FirstViewModel): ViewModel

}