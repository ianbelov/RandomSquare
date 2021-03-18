package com.a.randomsquare.di.component

import android.app.Application
import com.a.randomsquare.MyApp
import com.a.randomsquare.di.module.*
import com.a.randomsquare.viewmodel.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [FragmentsModule::class, AndroidSupportInjectionModule::class, ContextModule::class, HeavyObjectModule::class]
)
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(myApp: MyApp)
}