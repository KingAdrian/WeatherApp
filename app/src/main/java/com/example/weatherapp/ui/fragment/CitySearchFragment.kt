package com.example.weatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentCitySearchBinding
import com.example.weatherapp.viewmodel.WeatherViewModel

class CitySearchFragment : Fragment() {

    private val viewModel by activityViewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentCitySearchBinding = FragmentCitySearchBinding.inflate(inflater,container,false)
        binding.let {
            it.viewModel = viewModel
            it.lifecycleOwner = this
        }
        viewModel.navigateToListView.observe(viewLifecycleOwner) {
            if(it==true) {
                findNavController().navigate(R.id.action_citySearchFragment_to_weatherListFragment)
                viewModel.navigateToListView.value=false
            }
            viewModel.progressVisibility.value = false
        }

        viewModel.liveDataCityName.observe(viewLifecycleOwner) {
            viewModel.progressVisibility.value = false
            viewModel.liveDataCityNameError.value = ""
        }
        return binding.root
    }

}