package com.github.pierry.test.core.di

import com.github.pierry.test.core.data.FloatingMountainApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

  val BASE_URL = "https://floating-mountain-50292.herokuapp.com/"

  @Provides
  fun providesIDdogApi(retrofit: Retrofit): FloatingMountainApi {
    return retrofit.create<FloatingMountainApi>(FloatingMountainApi::class.java)
  }

  @Provides
  fun providesRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
  }

  @Provides
  fun providesGson(): Gson {
    return GsonBuilder()
            .create()
  }

  @Provides
  fun providesOkHttpClientDashboard(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    val okhttp = OkHttpClient.Builder()
    okhttp.addInterceptor(loggingInterceptor)
    return okhttp.build()
  }

  @Provides
  fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
  }

}