package com.gobi.sweetbrew.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gobi.sweetbrew.domain.usecase.GetCoffeeListUseCase
import com.gobi.sweetbrew.domain.usecase.GetPromotionsUseCase
import com.gobi.sweetbrew.presentation.screens.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val getCoffeeListUseCase: GetCoffeeListUseCase,
  private val getPromotionsUseCase: GetPromotionsUseCase
) : ViewModel() {

  private val _uiState = MutableStateFlow(HomeUiState())
  val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

  init {
    loadData()
  }

  private fun loadData() {
    viewModelScope.launch {
      _uiState.update { it.copy(isLoading = true) }

      try {
        // Collect coffee list
        getCoffeeListUseCase().collect { coffees ->
          _uiState.update { it.copy(coffees = coffees) }
        }

        // Collect promotions
        getPromotionsUseCase().collect { promotions ->
          _uiState.update { it.copy(promotions = promotions) }
        }
      } catch (e: Exception) {
        _uiState.update { it.copy(error = e.message) }
      } finally {
        _uiState.update { it.copy(isLoading = false) }
      }
    }
  }
}
