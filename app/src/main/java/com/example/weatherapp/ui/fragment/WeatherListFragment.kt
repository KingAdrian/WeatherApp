package com.example.weatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.ui.adapter.WeatherListAdapter
import com.example.weatherapp.databinding.FragmentWeatherListBinding
import com.example.weatherapp.utils.setDivider
import com.example.weatherapp.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_weather.*


class WeatherListFragment : Fragment() {

    val viewModel by activityViewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentWeatherListBinding.inflate(inflater, container, false)

        binding.apply {
            this.viewModel = this@WeatherListFragment.viewModel
            this.lifecycleOwner = this@WeatherListFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().toolbar.title = viewModel.liveDataCityName.value?.toUpperCase()

        viewModel.adapter = WeatherListAdapter {
            viewModel.setSelectedWeather(it)
            findNavController().navigate(R.id.action_weatherListFragment_to_weatherDetailsFragment)
        }
    }

}