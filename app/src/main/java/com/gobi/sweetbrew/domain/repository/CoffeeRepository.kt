package com.gobi.sweetbrew.domain.repository

import com.gobi.sweetbrew.data.models.Coffee
import com.gobi.sweetbrew.data.models.Promotion
import kotlinx.coroutines.flow.Flow

interface CoffeeRepository {
  suspend fun getCoffeeList(): Flow<List<Coffee>>
  suspend fun getPromotions(): Flow<List<Promotion>>
}
