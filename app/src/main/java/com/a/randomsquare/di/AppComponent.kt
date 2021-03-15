package com.a.randomsquare.di

import com.a.randomsquare.MainFragment
import dagger.Component

@Component(modules = [ColorsGeneratorModule::class])
interface AppComponent {
    fun inject(fragment: MainFragment)
}