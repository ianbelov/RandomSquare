package com.a.randomsquare.di.component

import com.a.randomsquare.main.MainFragment
import com.a.randomsquare.di.module.AppModule
import com.a.randomsquare.di.module.ColorsGeneratorModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ColorsGeneratorModule::class, AppModule::class, AndroidSupportInjectionModule::class])
interface AppComponent {
    fun inject(fragment: MainFragment)
}