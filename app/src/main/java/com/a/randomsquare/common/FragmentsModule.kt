package com.a.randomsquare.common

import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.first.FirstFragment
import com.a.randomsquare.first.FirstFragmentModule
import com.a.randomsquare.second.SecondFragment
import com.a.randomsquare.second.SecondFragmentModule
import com.a.randomsquare.third.ThirdFragment
import com.a.randomsquare.third.ThirdFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule() {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
    abstract fun firstFragment(): FirstFragment

    @ContributesAndroidInjector(modules = [SecondFragmentModule::class])
    abstract fun secondFragment(): SecondFragment

    @ContributesAndroidInjector(modules = [ThirdFragmentModule::class])
    abstract fun thirdFragment(): ThirdFragment
}