package com.gobi.sweetbrew.domain.usecase

import com.gobi.sweetbrew.data.models.Promotion
import com.gobi.sweetbrew.domain.repository.CoffeeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPromotionsUseCase @Inject constructor(
  private val repository: CoffeeRepository
) {
  suspend operator fun invoke(): Flow<List<Promotion>> = repository.getPromotions()
}
