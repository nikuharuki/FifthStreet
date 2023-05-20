package com.example.fifthstreet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fifthstreet.databinding.ActivityFoodDetailsBinding


class FoodDetails : AppCompatActivity() {

    private lateinit var binding: ActivityFoodDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val food = intent.getParcelableExtra("Food") as Food?

        if (food!=null){
            binding.tvFoodName.text = food.name
            binding.tvFoodPrice.text = resources.getString(R.string.food_price, food.price)
            binding.imageView.setImageResource(food.image)
            binding.tvFoodDesc.text = food.description
            binding.tvFoodConcName.text = food.concessionaire

            //change splash background each concessionaire
            if (binding.tvFoodConcName.text == "Belgian Waffles"){
                binding.imageView.setBackgroundResource(R.drawable.splash_food_details_bw)
            }
            if (binding.tvFoodConcName.text == "Coffee Bean"){
                binding.imageView.setBackgroundResource(R.drawable.splash_food_details_cb)
            }

            //item count and computation
            binding.addBtn.setOnClickListener {

                var count = binding.tvItemCount.text.toString().toInt()
                count++

                binding.tvItemCount.text = count.toString()

                //ginawa ko to cuz i received an error "Do not concatenate text displayed with setText. Use resource string with placeholders"
                binding.tvFoodPrice.text = resources.getString(R.string.food_price, count * food.price)
            }

            binding.removeBtn.setOnClickListener {

                var count = binding.tvItemCount.text.toString().toInt()
                if (count > 1){
                    count--
                }

                binding.tvItemCount.text = count.toString()
                binding.tvFoodPrice.text = resources.getString(R.string.food_price, count * food.price)
            }



        }


    }

}