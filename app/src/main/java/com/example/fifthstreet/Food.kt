package com.example.fifthstreet

import android.os.Parcel
import android.os.Parcelable

data class Food(val image: Int, val name: String, val price: Double, val description: String, val concessionaire : String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeDouble(price)
        parcel.writeString(description)
        parcel.writeString(concessionaire)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Food> {
        override fun createFromParcel(parcel: Parcel): Food {
            return Food(parcel)
        }

        override fun newArray(size: Int): Array<Food?> {
            return arrayOfNulls(size)
        }
    }
}

class PotatoCorner {
    companion object {
        fun getFoodList(): ArrayList<Food> {
            val foodList = ArrayList<Food>()
            foodList.add(
                Food(
                    R.drawable.potatocorner_regular,
                    "Regular",
                    29.00,
                    "Maliit",
                    "Potato Corner"
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_large,
                    "Large",
                    55.00,
                    "Malaki slight",
                    "Potato Corner"
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_jumbo,
                    "Jumbo",
                    85.00,
                    "Malaki na",
                    "Potato Corner"
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_mega,
                    "Mega",
                    110.00,
                    "Malaki na talaga",
                    "Potato Corner"
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_giga,
                    "Giga",
                    179.00,
                    "Grabe ang laki",
                    "Potato Corner"
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_tera,
                    "Tera",
                    199.00,
                    "ANG LAKEEEE!!!",
                    "Potato Corner"
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
                    35.00,
                    "Walang lasa",
                    "Belgian Waffles"
                )
            )
            foodList.add(
                Food(
                    R.drawable.bw_icecream,
                    "Ice Cream",
                    65.00,
                    "Superior",
                    "Belgian Waffles"
                )
            )
            foodList.add(
                Food(
                    R.drawable.bw_banana,
                    "Banana",
                    45.00,
                    "Haha banana",
                    "Belgian Waffles"
                )
            )
            foodList.add(
                Food(
                    R.drawable.bw_strawberry,
                    "Strawberry",
                    55.00,
                    "Acm hehe",
                    "Belgian Waffles"
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
                    155.00,
                    "Ayaw ni Justine",
                 "Coffee Bean"
                )
            )
            return foodList
        }
    }
}

