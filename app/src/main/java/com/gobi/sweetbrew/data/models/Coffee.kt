package com.gobi.sweetbrew.data.models

data class Coffee(
  val id: String,
  val name: String,
  val description: String,
  val category: String,
  val price: Double,
  val currency: String,
  val sizeOptions: List<String>,
  val availability: Boolean,
  val rating: Double,
  val imageUrl: String,
  val ingredients: List<String>,
  val nutritionFacts: NutritionFacts,
  val createdAt: String
)
