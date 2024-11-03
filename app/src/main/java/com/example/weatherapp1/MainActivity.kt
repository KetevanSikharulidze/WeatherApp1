package com.example.weatherapp1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapp1.databinding.ActivityMainBinding
import org.json.JSONObject
import kotlin.math.log

const val API_KEY = "30526069901d408fa5a182653240311"

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.BtnGetWeather.setOnClickListener {
            getResult("London")
        }

    }

    private fun getResult(name: String){
        val url = "https://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY&q=$name&aqi=no\n"
        val queue = Volley.newRequestQueue(this) // ამითი ვაგზავნით მოთხოვნას
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {
                response ->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog","response: ${temp.getString("temp_c")}") //response
            },
            {
                Log.d("MyLog",it.toString()) //error
            }
            )
        queue.add(stringRequest) //აქ ვამატებთ ახალ მოთხოვნას
    }
}