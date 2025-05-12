package com.gobi.sweetbrew.domain.services

import com.gobi.sweetbrew.data.models.CoffeeListResponse
import com.gobi.sweetbrew.data.models.PromotionListResponse
import retrofit2.http.GET

interface ApiService {
  @GET("products/getallproducts")
  suspend fun getCoffeeList(): CoffeeListResponse

  @GET("promotions/getdbpromotions")
  suspend fun getPromotions(): PromotionListResponse
}
