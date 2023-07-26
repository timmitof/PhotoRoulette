package com.timmitof.photoroulette.di

import android.content.Context
import com.timmitof.photoroulette.PhotoRouletteApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return PhotoRouletteApp.instance
    }
}