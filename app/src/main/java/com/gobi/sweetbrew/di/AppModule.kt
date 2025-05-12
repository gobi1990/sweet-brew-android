package com.gobi.sweetbrew.di

import com.gobi.sweetbrew.domain.repository.CoffeeRepository
import com.gobi.sweetbrew.domain.repository.CoffeeRepositoryImpl
import com.gobi.sweetbrew.domain.services.ApiService
import com.gobi.sweetbrew.domain.services.RetrofitClient
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
  fun provideApiService(): ApiService = RetrofitClient.apiService

  @Provides
  @Singleton
  fun provideCoffeeRepository(apiService: ApiService): CoffeeRepository =
    CoffeeRepositoryImpl(apiService)
}
