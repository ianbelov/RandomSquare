package com.a.randomsquare.di.component

import android.app.Application
import android.content.Context
import com.a.randomsquare.App
import com.a.randomsquare.main.MainFragment
import com.a.randomsquare.di.module.AppModule
import com.a.randomsquare.di.module.ColorsGeneratorModule
import com.a.randomsquare.di.module.ContextModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ColorsGeneratorModule::class, AppModule::class, AndroidSupportInjectionModule::class, ContextModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(app: App)
}