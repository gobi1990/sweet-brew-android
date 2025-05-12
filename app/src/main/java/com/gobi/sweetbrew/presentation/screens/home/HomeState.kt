package com.gobi.sweetbrew.presentation.screens.home

import com.gobi.sweetbrew.data.models.Coffee
import com.gobi.sweetbrew.data.models.Promotion

data class HomeUiState(
  val isLoading: Boolean = false,
  val coffees: List<Coffee> = emptyList(),
  val promotions: List<Promotion> = emptyList(),
  val error: String? = null
)
