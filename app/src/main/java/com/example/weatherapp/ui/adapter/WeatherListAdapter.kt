package com.example.weatherapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.models.WeatherDataDTO

import com.example.weatherapp.utils.inflate
import kotlinx.android.synthetic.main.weather_list_item.view.*

class WeatherListAdapter(private var onClickItem: (WeatherDataDTO) -> Unit) : WeatherRecyclerViewAdapter<WeatherDataDTO, WeatherListAdapter.WeatherViewHolder>() {
    val list:ArrayList<WeatherDataDTO> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder =
        WeatherViewHolder(parent.inflate(R.layout.weather_list_item),onClickItem)

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) = holder.loadData(position)

    override fun getItemCount(): Int = list.size

    inner class WeatherViewHolder(private val view: View, private val onClickItem: ((WeatherDataDTO) -> Unit?)?) : RecyclerView.ViewHolder(view) {

        fun loadData(position: Int) {
            val data = list[position]

            view.apply {
               setBackgroundResources( this.item,data.weather?.get(0)?.icon ?: "")
                this.weather_title.text = data.weather?.get(0)?.main ?: ""
                this.weather_temp.text = String.format(view.context.getString(R.string.degree_temp_format),data.main?.temp?.toString()?:"0.0")
                this.setOnClickListener {
                    onClickItem?.let { onClick -> onClick(data) }
                }
            }

        }

    }

    fun setBackgroundResources(constraintLayout: RelativeLayout, url: String){
        when(url){
            "01d" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_sunny_weather","drawable", constraintLayout.context.packageName))
            "01n" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_sunny_weather","drawable", constraintLayout.context.packageName))
            "02d" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_sunny_weather","drawable", constraintLayout.context.packageName))
            "02n" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_cloudly_weather","drawable", constraintLayout.context.packageName))
            "03d" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_cloudly_weather","drawable", constraintLayout.context.packageName))
            "03n" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_cloudly_weather","drawable", constraintLayout.context.packageName))
            "04d" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_cloudly_weather","drawable", constraintLayout.context.packageName))
            "04n" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_cloudly_weather","drawable", constraintLayout.context.packageName))
            "09d" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_rainy_weather","drawable", constraintLayout.context.packageName))
            "09n" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_rainy_weather","drawable", constraintLayout.context.packageName))
            "10d" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_rainy_weather","drawable", constraintLayout.context.packageName))
            "10n" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_rainy_weather","drawable", constraintLayout.context.packageName))
            "11d" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_rainy_weather","drawable", constraintLayout.context.packageName))
            "11n" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_rainy_weather","drawable", constraintLayout.context.packageName))
            "13d" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_snowy_weather","drawable", constraintLayout.context.packageName))
            "13n" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_snowy_weather","drawable", constraintLayout.context.packageName))
            "50d" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_foggy_weather","drawable", constraintLayout.context.packageName))
            "50n" -> constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("background_foggy_weather","drawable", constraintLayout.context.packageName))
        }
    }

    override fun updateData(data: List<WeatherDataDTO>) {
        this.list.clear()
        if (data.isNotEmpty()) {
            this.list.addAll(data)
        }
        notifyDataSetChanged()
    }
}