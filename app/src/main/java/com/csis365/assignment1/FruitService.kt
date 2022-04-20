package com.csis365.assignment1

import com.csis365.assignment1.dto.Fruit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FruitService {
    @GET("api/fruit/all")
    fun getAllFruit(): Call<List<Fruit>>

    @GET("api/fruit/{name}")
    fun getFruitName(@Path("name") name : String) : Call<Fruit>
}