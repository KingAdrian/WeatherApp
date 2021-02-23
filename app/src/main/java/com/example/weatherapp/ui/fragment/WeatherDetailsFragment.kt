package com.example.weatherapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.weatherapp.databinding.FragmentWeatherDetailsBinding
import com.example.weatherapp.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherDetailsFragment : Fragment() {

    val viewModel by activityViewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentWeatherDetailsBinding.inflate(inflater,container,false)
        binding.viewModel= viewModel
        binding.lifecycleOwner = this
        requireActivity().toolbar.title = viewModel.liveDataCityName.value?.toUpperCase()
        return binding.root
    }

}