package com.example.philcororetro.di

import android.app.Application
import com.example.philcororetro.MyApp
import com.example.philcororetro.di.base.MyAppDatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        // Dagger support
        AndroidInjectionModule::class,

        // App
        MyAppDatabaseModule::class,
        RetrofitServiceModule::class,
        ActivityModule::class,
         ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(myApp: MyApp)
}
