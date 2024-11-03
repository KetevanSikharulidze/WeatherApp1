package com.example.weatherapp1.fragments

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.isPermissionGranted(p: String): Boolean {
    return ContextCompat.checkSelfPermission(
        activity as AppCompatActivity, p) ==PackageManager.PERMISSION_GRANTED
    //checkSelfPermission ფუნქცია შეამოწმებს გვაქვს თუარა წვდომა, თუ გვაქვს დააბრუნებს 1-ს, თუარა ე.ი. -1
    //ხოლო თუ ბოლოში ვუწერთ PackageManager-ს, ის თავის თავში შეიცავს PERMISSION_GRANTED-ს,
    //და ასეთის შემთხვევაში ის დააბრუნებს, შესაბამისად true-ს ან false-ს.
}