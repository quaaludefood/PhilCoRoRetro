package com.example.philcororetro.di.base

import android.app.Application
import com.example.philcororetro.local.ActionDao
import com.example.philcororetro.local.MyAppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MyAppDatabaseModule {
    @Singleton
    @Provides
    fun provideDb(app: Application): MyAppDatabase = MyAppDatabase.buildDefault(app)

    @Singleton
    @Provides
    fun provideUserDao(db: MyAppDatabase): ActionDao = db.actionDao()
}