package com.gobi.sweetbrew.data.models

data class Promotion(
  val id: String,
  val createdAt: String,
  val title: String,
  val description: String,
  val discount: String,
  val endTime: String,
  val validUntil: String,
  val imageUrl: String,
  val startTime: String
)
