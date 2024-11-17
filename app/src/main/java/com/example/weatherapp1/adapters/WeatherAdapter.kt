package com.example.weatherapp1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp1.R
import com.example.weatherapp1.databinding.ListItemBinding
import com.example.weatherapp1.models.WeatherModel
import com.squareup.picasso.Picasso

class WeatherAdapter : ListAdapter<WeatherModel, WeatherAdapter.Holder>(Comparator()) {

    class Holder(view: View): RecyclerView.ViewHolder(view){
        val binding = ListItemBinding.bind(view)

        fun bind(item: WeatherModel) = with(binding){
            tvDate.text = item.time
            tvCondition.text = item.condition
            tvTemp.text = item.currentTemp
            Picasso.get().load("https:" + item.imageUrl).into(im)
        } //როგორ ვავსებთ
    }

    class Comparator: DiffUtil.ItemCallback<WeatherModel>(){
        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem // იმ შემთხვევაში თუ გვაქვს უნიკალური ელემენტი აითემში, მაშინ აქ შეგვიძლია შევადაროთ id-ით, ანუ ამ უნიკალური ელემენტით.
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem // აქ უბრალოდ ძველ და ახალ აითემებს ვადარებთ.
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return Holder(view)
    } // ვქმნით

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    } // ვავსებთ
}