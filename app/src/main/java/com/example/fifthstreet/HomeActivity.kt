package com.example.fifthstreet

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fifthstreet.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        binding.friesBtn.performClick()
        var animator1 : ValueAnimator? = null
        var animator2 : ValueAnimator? = null
        var animator3 : ValueAnimator? = null
        var activeAnimator : ValueAnimator? = null


        binding.friesBtn.setOnClickListener {

                if (activeAnimator !== animator1 || animator1 == null) {
                    activeAnimator?.reverse()

                    binding.tvFries.text = "Potato Corner"
                    binding.tvFries.visibility = View.VISIBLE
                    binding.tvFries.measure(0, 0)

                    animator1 = createAnimator(binding.tvFries)
                    animator1!!.start()
                    activeAnimator = animator1

                    //clear muna lahat ng laman ng foodlist
                    foodList.clear()
                    foodList.addAll(PotatoCorner.getFoodList()) // Get the new data from the food concessionaire class
                    foodAdapter.updateData(foodList)

                }


        }

        binding.waffleBtn.setOnClickListener {

            if (activeAnimator !== animator2 || animator2 == null) {
                activeAnimator?.reverse()

                binding.tvWaffle.text = "Belgian Waffles"
                binding.tvWaffle.visibility = View.VISIBLE
                binding.tvWaffle.measure(0, 0)

                animator2 = createAnimator(binding.tvWaffle)
                animator2!!.start()
                activeAnimator = animator2

                //clear muna lahat ng laman ng foodlist
                foodList.clear()
                foodList.addAll(BelgianWaffles.getFoodList()) // Get the new data from the food concessionaire class
                foodAdapter.updateData(foodList)
            }


        }

        binding.coffeeBtn.setOnClickListener {

            if (activeAnimator !== animator3 || animator3 == null) {
                activeAnimator?.reverse()

                binding.tvCoffee.text = "Starbucks"
                binding.tvCoffee.visibility = View.VISIBLE
                binding.tvCoffee.measure(0, 0)

                animator3 = createAnimator(binding.tvCoffee)
                animator3!!.start()
                activeAnimator = animator3

                //clear muna lahat ng laman ng foodlist
                foodList.clear()
                foodList.addAll(CoffeeBean.getFoodList()) // Get the new data from the food concessionaire class
                foodAdapter.updateData(foodList)

            }
        }

        binding.friesBtn.performClick()
    }

    private fun createAnimator(textview : TextView): ValueAnimator {

        val initSize = textview.measuredWidth

        val animator = ValueAnimator.ofInt(0,initSize)
        animator.duration = 250


        animator.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            val layoutParams = textview.layoutParams
            layoutParams.width = value
            textview.requestLayout()
        }
        return animator
    }



    private fun init(){
        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = GridLayoutManager(this,2)

        foodList = ArrayList()

        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter

    }
}