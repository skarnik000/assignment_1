package com.csis365.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.csis365.assignment1.dto.Fruit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FruitDetailActivity : AppCompatActivity() {

    private lateinit var tvGenus: TextView
    private lateinit var tvName : TextView
    private lateinit var tvFamily : TextView
    private lateinit var tvOrder : TextView
    private lateinit var tvCarbs : TextView
    private lateinit var tvProtein: TextView
    private lateinit var tvFat : TextView
    private lateinit var tvCalorie: TextView
    private lateinit var tvSugar: TextView
    private lateinit var btnBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_detail)

        tvGenus = findViewById(R.id.tv_genus)
        tvName = findViewById(R.id.tv_FruitDetailName)
        tvFamily = findViewById(R.id.tv_family)
        tvOrder = findViewById(R.id.tv_order)

        tvCarbs = findViewById(R.id.tv_carbs)
        tvProtein = findViewById(R.id.tv_protein)
        tvFat = findViewById(R.id.tv_fat)
        tvCalorie = findViewById(R.id.tv_calories)
        tvSugar = findViewById(R.id.tv_sugar)

        btnBack = findViewById(R.id.btn_back)

        val fruitName = intent.extras?.getString("fruitName").toString()
        val fruitService = buildService()
        fruitService.getFruitName(fruitName).enqueue(object : Callback<Fruit> {
            override fun onResponse(call: Call<Fruit>, response: Response<Fruit>) {
                Log.i("asdf","onResponse")
                val fruit : Fruit? = response.body()
                if (fruit != null) {
                    tvName.text = fruit.name.toString()
                    tvGenus.text = "Genus : " + fruit.genus.toString()
                    tvFamily.text = "Family : " + fruit.family.toString()
                    tvOrder.text = "Order : " + fruit.order.toString()

                    tvCarbs.text = "Carbs: " + fruit.nutritions?.carbohydrates.toString()
                    tvProtein.text = "Protein : " + fruit.nutritions?.protein.toString()
                    tvFat.text = "Fat : " + fruit.nutritions?.fat.toString()
                    tvCalorie.text = "Calories : " + fruit.nutritions?.calories.toString()
                    tvSugar.text = "Sugar : " + fruit.nutritions?.sugar.toString()
                }else{
                    Log.e("asdf","no fruit")
                }
            }

            override fun onFailure(call: Call<Fruit>, t: Throwable) {
                Log.e("asdf","onFailure")
            }

        })

        btnBack.setOnClickListener {
            this.finish()
        }
    }

    private fun buildService(): FruitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(FruitService::class.java)

    }
}