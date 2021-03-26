package com.a.randomsquare.myname

import androidx.lifecycle.ViewModel
import com.a.randomsquare.util.ViewModelKey
import com.a.randomsquare.util.namegenerator.INameGenerator
import com.a.randomsquare.util.namegenerator.MyNameGeneratorImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MyNameFragmentModule {

    @Binds
    abstract fun provideNameGenerator(generator: MyNameGeneratorImpl): INameGenerator

    @Binds
    @IntoMap
    @ViewModelKey(MyNameViewModel::class)
    internal abstract fun secondViewModel(viewModel: MyNameViewModel): ViewModel
}