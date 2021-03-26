package com.a.randomsquare.di

import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.color.ColorFragment
import com.a.randomsquare.color.ColorFragmentModule
import com.a.randomsquare.colorname.ColorNameFragment
import com.a.randomsquare.colorname.ColorNameFragmentModule
import com.a.randomsquare.myname.MyNameFragment
import com.a.randomsquare.myname.MyNameFragmentModule
import com.a.randomsquare.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule() {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = [ColorFragmentModule::class])
    abstract fun firstFragment(): ColorFragment

    @ContributesAndroidInjector(modules = [ColorNameFragmentModule::class])
    abstract fun secondFragment(): ColorNameFragment

    @ContributesAndroidInjector(modules = [MyNameFragmentModule::class])
    abstract fun thirdFragment(): MyNameFragment
}