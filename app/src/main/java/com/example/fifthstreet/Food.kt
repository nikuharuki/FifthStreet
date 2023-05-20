package com.example.fifthstreet

data class Food(val image: Int, val name: String, val price: String, val description: String)

class PotatoCorner {
    companion object {
        fun getFoodList(): ArrayList<Food> {
            val foodList = ArrayList<Food>()
            foodList.add(
                Food(
                    R.drawable.potatocorner_regular,
                    "Regular",
                    "₱ 29.00",
                    "Maliit"
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_large,
                    "Large",
                    "₱ 55.00",
                    "Malaki slight"
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_jumbo,
                    "Jumbo",
                    "₱ 85.00",
                    "Malaki na"
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_mega,
                    "Mega",
                    "₱ 110.00",
                    "Malaki na talaga"
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_giga,
                    "Giga",
                    "₱ 179.00",
                    "Grabe ang laki"
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_tera,
                    "Tera",
                    "₱ 199.00",
                    "ANG LAKEEEE!!!"
                )
            )

            return foodList
        }
    }
}

class BelgianWaffles {
    companion object {
        fun getFoodList(): ArrayList<Food> {
            val foodList = ArrayList<Food>()
            foodList.add(
                Food(
                    R.drawable.bw_plain,
                    "Plain",
                    "₱ 35.00",
                    "Walang lasa"
                )
            )
            foodList.add(
                Food(
                    R.drawable.bw_icecream,
                    "Ice Cream",
                    "₱ 65.00",
                    "Superior"
                )
            )
            foodList.add(
                Food(
                    R.drawable.bw_banana,
                    "Banana",
                    "₱ 45.00",
                    "Haha banana"
                )
            )
            foodList.add(
                Food(
                    R.drawable.bw_strawberry,
                    "Strawberry",
                    "₱ 55.00",
                    "Acm hehe"
                )
            )
            return foodList
        }
    }
}

class CoffeeBean {
    companion object {
        fun getFoodList(): ArrayList<Food> {
            val foodList = ArrayList<Food>()
            foodList.add(
                Food(
                    R.drawable.cb_matcha,
                    "Matcha",
                    "₱ 155.00",
                    "Ayaw ni Justine"
                )
            )
            return foodList
        }
    }
}

