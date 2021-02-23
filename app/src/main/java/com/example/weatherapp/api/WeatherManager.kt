package com.example.weatherapp.api

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.models.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val GET_WEATHER :String = "data/2.5/forecast"
class WeatherManager {
    private val service:WeatherService
    private val retrofit = ApiClient.providesRetrofit()
    init {
        service = retrofit.create(WeatherService::class.java)
    }

    suspend fun getWeather(cityName:String) = service.getWeather(cityName)

    interface WeatherService{

        @GET(GET_WEATHER)
        suspend fun getWeather(@Query("q")cityName:String,
                               @Query("appid")appId:String = BuildConfig.SECRET_KEY,
                               @Query("units")metric:String ="metric")
        :Response<APIResponse>
    }
}