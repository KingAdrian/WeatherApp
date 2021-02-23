package com.example.weatherapp.models

data class APIResponse (

        val cod:String?,
        val message:Int?,
        val cnt:Int?,
        val list:List<WeatherDataDTO>
)