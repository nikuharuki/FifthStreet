package com.example.fifthstreet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foodList: ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val foodName: TextView = itemView.findViewById(R.id.tv_FoodName)
        val foodPrice = itemView.findViewById<TextView>(R.id.tv_FoodPrice)
        val foodDescription = itemView.findViewById<TextView>(R.id.tv_FoodDescription)
    }
    fun updateData(newData: List<Food>) {
//        foodList.clear()
//        foodList.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.imageView.setImageResource(food.image)
        holder.foodName.text = food.name
        holder.foodPrice.text = food.price
        holder.foodDescription.text = food.description
    }
}