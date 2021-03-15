package com.a.randomsquare.di

import com.a.randomsquare.ColorsGenerator
import com.a.randomsquare.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ColorsGeneratorModule::class, ContextModule::class])
interface AppComponent {
    fun inject(fragment: MainFragment)
}