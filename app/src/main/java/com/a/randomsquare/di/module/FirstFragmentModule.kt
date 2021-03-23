package com.a.randomsquare.di.module

import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.util.colorsgenerator.INameGenerator
import com.a.randomsquare.util.colorsgenerator.NameGeneratorImpl
import com.a.randomsquare.util.colorsgenerator.SecondColorsGeneratorImpl
import com.a.randomsquare.viewmodel.FirstViewModel
import com.a.randomsquare.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
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