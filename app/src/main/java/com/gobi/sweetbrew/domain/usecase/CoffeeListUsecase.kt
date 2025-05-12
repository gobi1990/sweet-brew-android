package com.gobi.sweetbrew.domain.usecase

import com.gobi.sweetbrew.data.models.Coffee
import com.gobi.sweetbrew.domain.repository.CoffeeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoffeeListUseCase @Inject constructor(
  private val repository: CoffeeRepository
) {
  suspend operator fun invoke(): Flow<List<Coffee>> = repository.getCoffeeList()
}
