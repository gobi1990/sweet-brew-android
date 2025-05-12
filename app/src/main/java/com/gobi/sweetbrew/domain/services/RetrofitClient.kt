package com.gobi.sweetbrew.domain.services

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
  private const val BASE_URL = "https://gobi-custom-api.vercel.app/api/v1/"

  private var accessToken: String? = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjM4ZTZlYzU4LTM1OTItNGNjZi1iY2RkLTcwYmY0NDc0NjFhZSIsImVtYWlsIjoiZ29iaUBnbWFpbC5jb20iLCJyb2xlIjoiYWRtaW4iLCJpYXQiOjE3NDIxNzk5NjksImV4cCI6MTc0MjE4MzU2OX0.Xc3vuf_oJEn_MhqDDwxELbP703v-PSYB9IzadDI4mUI"

  private val authInterceptor = Interceptor { chain ->
    val originalRequest = chain.request()
    val newRequest = originalRequest.newBuilder()
      .apply {
        accessToken?.let { token ->
          header("Authorization", "Bearer $token")
        }
      }
      .build()
    chain.proceed(newRequest)
  }

  private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(authInterceptor)
    .build()

  val apiService: ApiService by lazy {
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(okHttpClient) // Use OkHttpClient with interceptor
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(ApiService::class.java)
  }

  fun updateAccessToken(newToken: String?) {
    accessToken = newToken
  }
}
