package com.a.randomsquare.di.module

import com.a.randomsquare.main.FirstFragment
import com.a.randomsquare.main.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule() {

    @ContributesAndroidInjector()
    abstract fun firstFragment(): FirstFragment

    @ContributesAndroidInjector()
    abstract fun secondFragment(): SecondFragment
}