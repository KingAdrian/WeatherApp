package com.example.weatherapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView


abstract class WeatherRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    abstract fun updateData(data: List<T>)
}
