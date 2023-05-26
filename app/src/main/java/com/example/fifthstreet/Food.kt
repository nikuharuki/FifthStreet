package com.example.fifthstreet

import android.os.Parcel
import android.os.Parcelable

data class Food(val image: Int, val name: Int, val price: Double, val description: Int, val concessionaire : Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeInt(name)
        parcel.writeDouble(price)
        parcel.writeInt(description)
        parcel.writeInt(concessionaire)
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
                    R.string.regular,
                    29.00,
                    R.string.maliit,
                    R.string.potato_corner
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_large,
                    R.string.large,
                    55.00,
                    R.string.malaki_slight,
                    R.string.potato_corner
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_jumbo,
                    R.string.jumbo,
                    85.00,
                    R.string.malaki_na,
                    R.string.potato_corner
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_mega,
                    R.string.mega,
                    110.00,
                    R.string.malaki_na_talaga,
                    R.string.potato_corner
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_giga,
                    R.string.giga,
                    179.00,
                    R.string.grabe_ang_laki,
                    R.string.potato_corner
                )
            )
            foodList.add(
                Food(
                    R.drawable.potatocorner_tera,
                    R.string.tera,
                    199.00,
                    R.string.ang_lakeeee,
                    R.string.potato_corner
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
                    R.string.plain,
                    35.00,
                    R.string.walang_lasa,
                    R.string.belgian_waffles
                )
            )
            foodList.add(
                Food(
                    R.drawable.bw_icecream,
                    R.string.ice_cream,
                    65.00,
                    R.string.superior,
                    R.string.belgian_waffles
                )
            )
            foodList.add(
                Food(
                    R.drawable.bw_banana,
                    R.string.banana,
                    45.00,
                    R.string.haha_banana,
                    R.string.belgian_waffles
                )
            )
            foodList.add(
                Food(
                    R.drawable.bw_strawberry,
                    R.string.strawberry,
                    55.00,
                    R.string.acm_hehe,
                    R.string.belgian_waffles
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
                    R.string.matcha,
                    235.00,
                    R.string.ayaw_ni_justine,
                    R.string.coffee_bean
                )
            )
            foodList.add(
                Food(
                    R.drawable.cb_americano,
                    R.string.iced_americano,
                    185.00,
                    R.string.di_ba_pilipino,
                    R.string.coffee_bean
                )
            )
            foodList.add(
                Food(
                    R.drawable.cb_vanilla,
                    R.string.iced_vanilla_latte,
                    215.00,
                    R.string.vanila,
                    R.string.coffee_bean
                )
            )
            foodList.add(
                Food(
                    R.drawable.cb_caramel,
                    R.string.iced_caramel_macchiato,
                    225.00,
                    R.string.pano_i_pronounce,
                    R.string.coffee_bean
                )
            )
            return foodList
        }
    }
}

