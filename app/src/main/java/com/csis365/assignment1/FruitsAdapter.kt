package com.csis365.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.dto.Fruit

class FruitsAdapter(private val fruits: List<Fruit>) : RecyclerView.Adapter<FruitsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_fruit_list_text, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvFruitName.text = fruits[position].name

        holder.tvFruitName.setOnClickListener {
            val fruitDetailIntent = Intent(holder.tvFruitName.context,FruitDetailActivity::class.java)
            fruitDetailIntent.putExtra("fruitName",holder.tvFruitName.text.toString())
            startActivity(holder.tvFruitName.context, fruitDetailIntent, Bundle())

        }
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvFruitName: TextView = view.findViewById(R.id.tv_fruit_name)
    }
}