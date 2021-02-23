package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.ui.adapter.WeatherListAdapter
import com.example.weatherapp.api.WeatherManager
import com.example.weatherapp.models.WeatherDataDTO
import com.example.weatherapp.utils.SingleLiveEvent
import com.example.weatherapp.utils.getStringResponseFromRaw
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    val data: ArrayList<WeatherDataDTO> = ArrayList()
    var adapter: WeatherListAdapter? = null
    private var _selectedWeatherData: MutableLiveData<WeatherDataDTO> = MutableLiveData()
    var selectedWeatherData: LiveData<WeatherDataDTO>? = _selectedWeatherData

    var liveDataCityName: MutableLiveData<String> = MutableLiveData()
    var liveDataCityNameError: MutableLiveData<String> = MutableLiveData()
    val navigateToListView: SingleLiveEvent<Boolean> = SingleLiveEvent()
    var progressVisibility: MutableLiveData<Boolean> = MutableLiveData()

    fun searchCity() {
        val cityName: String? = liveDataCityName.value
        if (cityName?.isNotBlank() == true) {
            progressVisibility.value = true
            viewModelScope.launch {
                val response = WeatherManager().getWeather(cityName)
                val bodyData = response.body()?.list
                if (response.isSuccessful && bodyData != null) {
                    data.clear()
                    data.addAll(ArrayList(bodyData))
                    navigateToListView.postValue(true)
                } else {
                    val errorResponse = response.errorBody()?.let {
                        getStringResponseFromRaw(it)
                    }
                    liveDataCityNameError.postValue(errorResponse ?: "Error Response")
                    progressVisibility.value = false
                }
            }
        } else {
            liveDataCityNameError.postValue("Enter City Name")
        }
    }

    fun setSelectedWeather(weatherDataDTO: WeatherDataDTO) {
        _selectedWeatherData.value = weatherDataDTO
    }
}