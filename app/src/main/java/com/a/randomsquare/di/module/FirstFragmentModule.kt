package com.a.randomsquare.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.util.colorsgenerator.FirstColorsGeneratorImpl
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.ui.FirstFragment
import com.a.randomsquare.util.colorsgenerator.SecondColorsGeneratorImpl
import com.a.randomsquare.viewmodel.FirstViewModel
import com.a.randomsquare.viewmodel.ViewModelFactory
import com.a.randomsquare.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class FirstFragmentModule() {

    @Binds
    abstract fun provideFirstColorsGenerator(generator: FirstColorsGeneratorImpl): IColorsGenerator

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    internal abstract fun firstViewModel(viewModel: FirstViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}