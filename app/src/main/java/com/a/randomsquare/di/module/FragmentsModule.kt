package com.a.randomsquare.di.module

import com.a.randomsquare.ui.FirstFragment
import com.a.randomsquare.ui.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule(){

    @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
    abstract fun firstFragment(): FirstFragment

    @ContributesAndroidInjector(modules = [SecondFragmentModule::class])
    abstract fun secondFragment(): SecondFragment
}