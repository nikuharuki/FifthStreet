package com.example.fifthstreet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class FoodAdapter(private val context: Context, private val foodList: ArrayList<Food>) :


RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    var onItemClick: ((Food) -> Unit)? = null

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val foodName: TextView = itemView.findViewById(R.id.tv_FoodName)
        val foodPrice: TextView = itemView.findViewById(R.id.tv_FoodPrice)
        val foodDescription: TextView = itemView.findViewById(R.id.tv_FoodDescription)
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
        holder.foodName.text = context.getString(food.name)

        //"Do not concatenate text displayed with setText. Use resource string with placeholders"
        val priceText = holder.itemView.context.resources.getString(R.string.food_price, food.price)
        holder.foodPrice.text = priceText

        holder.foodDescription.text = context.getString(food.description)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(food)
        }
    }
}