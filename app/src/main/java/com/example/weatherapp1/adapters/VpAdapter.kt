package com.example.weatherapp1.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weatherapp1.fragments.DaysFragment
import com.example.weatherapp1.fragments.HoursFragment

class VpAdapter(fa: FragmentActivity, private val list: List<Fragment>): FragmentStateAdapter(fa) {

    override fun getItemCount() = list.size

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}