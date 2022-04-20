package com.csis365.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.dto.Fruit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FruitListActivity : AppCompatActivity() {

    private val fruitService = buildService()
    lateinit var rvFruits: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_list)

        rvFruits = findViewById(R.id.rv_fruits)
        rvFruits.layoutManager = LinearLayoutManager(this)

        //val fruitService = buildService()
        fruitService.getAllFruit().enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                Log.i("asdf","onResponse")
                rvFruits.adapter = FruitsAdapter(response.body().orEmpty())
            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                Log.e("asdf","onFailure")
            }

        })

    }

    private fun buildService(): FruitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(FruitService::class.java)

    }
}