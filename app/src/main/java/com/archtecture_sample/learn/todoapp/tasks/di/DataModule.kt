package com.archtecture_sample.learn.todoapp.tasks.di

import com.archtecture_sample.learn.todoapp.tasks.data.DataRepository
import com.archtecture_sample.learn.todoapp.tasks.data.DataRepositorySource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideDataRepository(dataRepository: DataRepository): DataRepositorySource
}
