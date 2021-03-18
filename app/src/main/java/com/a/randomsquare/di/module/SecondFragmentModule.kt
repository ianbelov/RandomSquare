package com.a.randomsquare.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.util.colorsgenerator.FirstColorsGeneratorImpl
import com.a.randomsquare.util.colorsgenerator.IColorsGenerator
import com.a.randomsquare.ui.FirstFragment
import com.a.randomsquare.ui.SecondFragment
import com.a.randomsquare.util.colorsgenerator.SecondColorsGeneratorImpl
import com.a.randomsquare.viewmodel.FirstViewModel
import com.a.randomsquare.viewmodel.SecondViewModel
import com.a.randomsquare.viewmodel.ViewModelFactory
import com.a.randomsquare.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class SecondFragmentModule {

    @Binds
    abstract fun provideSecondColorsGenerator(generator: SecondColorsGeneratorImpl): IColorsGenerator

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    internal abstract fun secondViewModel(viewModel: SecondViewModel): ViewModel

}