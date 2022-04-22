package uz.pdp.foodapp.models

import java.io.Serializable

data class TaomClass(
    var mealName : String,
    var mealItems : String,
    var mealDescriptions : String
) : Serializable
