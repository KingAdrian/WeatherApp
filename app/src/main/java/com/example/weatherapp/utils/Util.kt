package com.example.weatherapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.ui.adapter.WeatherRecyclerViewAdapter
import okhttp3.ResponseBody
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.collections.ArrayList

@BindingAdapter("android:converterInt")
fun convertToInt(view: TextView, value:Double){
    var valueInt = value.toInt()
    var valueStrin = valueInt.toString()
    view.text = valueStrin
}


@BindingAdapter("app:adapter", "app:data")
fun <T : WeatherRecyclerViewAdapter<*, *>> bind(
    recyclerView: RecyclerView,
    adapter: T,
    data: ArrayList<Nothing>
) {
    recyclerView.adapter = adapter
    adapter.updateData(data)
}

@BindingAdapter("layoutBackgroundImage")
fun setLayoutBackgroundImage(constraintLayout: ConstraintLayout, url: String?){
    when(url){
        "01d","02d","03d","04d","09d","10d","11d","13d","50d" -> {
            constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("ic_background_daylight","drawable", constraintLayout.context.packageName))
        }
        "01n","02n","03n","04n","09n","10n","11n","13n","50n" -> {
            constraintLayout.setBackgroundResource(constraintLayout.resources.getIdentifier("ic_background_night","drawable", constraintLayout.context.packageName))
        }
    }

}

@BindingAdapter("android:visibility")
fun setVisibility(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}

fun getStringResponseFromRaw(response: ResponseBody): String? {
    var reader: BufferedReader? = null
    val sb = StringBuilder()
    try {
        reader = BufferedReader(InputStreamReader(response.byteStream()))
        var line: String?
        try {
            while (reader.readLine().also { line = it } != null) {
                sb.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return sb.toString()
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    val divider = DividerItemDecoration(
            this.context,
            DividerItemDecoration.VERTICAL
    )
    val drawable = ContextCompat.getDrawable(
            this.context,
            drawableRes
    )
    drawable?.let {
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}

@BindingAdapter("imageResource")
fun setImageResource(imageview: ImageView, url:String){
    when(url){
        "01d" -> imageview.setImageDrawable(imageview, R.drawable.ic_01d)
        "01n" -> imageview.setImageDrawable(imageview, R.drawable.ic_01n)
        "02d" -> imageview.setImageDrawable(imageview, R.drawable.ic_02d)
        "02n" -> imageview.setImageDrawable(imageview, R.drawable.ic_02n)
        "03d" -> imageview.setImageDrawable(imageview, R.drawable.ic_03d)
        "03n" -> imageview.setImageDrawable(imageview, R.drawable.ic_03n)
        "04d" -> imageview.setImageDrawable(imageview, R.drawable.ic_04d)
        "04n" -> imageview.setImageDrawable(imageview, R.drawable.ic_04n)
        "09d" -> imageview.setImageDrawable(imageview, R.drawable.ic_09d)
        "09n" -> imageview.setImageDrawable(imageview, R.drawable.ic_09n)
        "10d" -> imageview.setImageDrawable(imageview, R.drawable.ic_10d)
        "10n" -> imageview.setImageDrawable(imageview, R.drawable.ic_10n)
        "11d" -> imageview.setImageDrawable(imageview, R.drawable.ic_11d)
        "11n" -> imageview.setImageDrawable(imageview, R.drawable.ic_11n)
        "13d" -> imageview.setImageDrawable(imageview, R.drawable.ic_13d)
        "13n" -> imageview.setImageDrawable(imageview, R.drawable.ic_13n)
        "50d" -> imageview.setImageDrawable(imageview, R.drawable.ic_50d)
        "50n" -> imageview.setImageDrawable(imageview, R.drawable.ic_50n)
    }

}

@BindingAdapter("backgroundResource")
fun setBackgroundResources(constraintLayout: ConstraintLayout, url: String){
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

private fun ImageView.setImageDrawable(view:ImageView,image: Int) {
    Glide.with(context).load(image).into(view)
}
