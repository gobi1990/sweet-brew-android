package com.gobi.sweetbrew.domain.repository

import com.gobi.sweetbrew.data.models.Coffee
import com.gobi.sweetbrew.data.models.Promotion
import com.gobi.sweetbrew.domain.services.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CoffeeRepositoryImpl @Inject constructor(
  private val apiService: ApiService
) : CoffeeRepository {

  override suspend fun getCoffeeList(): Flow<List<Coffee>> = flow {
    val response = apiService.getCoffeeList()
    if (response.status == "success") {
      emit(response.data.products)
    }
  }.flowOn(Dispatchers.IO)

  override suspend fun getPromotions(): Flow<List<Promotion>> = flow {
    val response = apiService.getPromotions()
    if (response.status == "success") {
      emit(response.data.promotions)
    }
  }.flowOn(Dispatchers.IO)
}
