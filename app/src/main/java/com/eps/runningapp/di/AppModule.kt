package com.eps.runningapp.di

import android.content.Context
import androidx.room.Room
import com.eps.runningapp.db.RunningDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRunningDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(
        app, RunningDatabase::class.java, "RUNNING_DATABASE"
    )

    @Singleton
    @Provides
    fun provideRunningDao(runningDatabase: RunningDatabase) = runningDatabase.getRunDao()
}