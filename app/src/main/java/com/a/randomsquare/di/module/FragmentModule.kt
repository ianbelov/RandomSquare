package com.a.randomsquare.di.module

import com.a.randomsquare.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule() {

    @ContributesAndroidInjector()
    abstract fun getMainFragment(): MainFragment
}