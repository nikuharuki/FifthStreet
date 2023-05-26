package com.example.fifthstreet

import android.content.Intent
import android.net.Uri
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
            binding.tvFoodName.text = this.getString(food.name)
            binding.tvFoodPrice.text = resources.getString(R.string.food_price, food.price)
            binding.imageView.setImageResource(food.image)
            binding.tvFoodDesc.text = this.getString(food.description)
            binding.tvFoodConcName.text = this.getString(food.concessionaire)

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

            binding.buyBtn.setOnClickListener {
                //send email

                val recipients = arrayOf(this.getString(food.concessionaire),
                    getString(R.string.potatocorner_email),
                    getString(R.string.belgianwaffles_email),
                    getString(R.string.coffeebean_email))

                val intentSelector = Intent(Intent.ACTION_SENDTO)
                intentSelector.data = Uri.parse("mailto:")

                val emailIntent = Intent(Intent.ACTION_SEND)

                when (this.getString(food.concessionaire)) {
                    this.getString(R.string.potato_corner) -> emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipients[1]))
                    this.getString(R.string.belgian_waffles) -> emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipients[2]))
                    this.getString(R.string.coffee_bean) -> emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipients[3]))
                }

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Fifth Street: Food Purchase")
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                    "Order/s:" +
                            "\n Food: " + this.getString(food.name) +
                            "\nQuantity: " + binding.tvItemCount.text.toString() +
                            "\n\nPrice: " + binding.tvFoodPrice.text.toString())
                emailIntent.selector = intentSelector
                startActivity(Intent.createChooser(emailIntent, "Send email"))


            }

        }

    }

}