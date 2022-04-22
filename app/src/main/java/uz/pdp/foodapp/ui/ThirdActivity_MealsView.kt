package uz.pdp.foodapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_third_meals_view.*
import uz.pdp.foodapp.R
import uz.pdp.foodapp.adapters.MyMealsAdapter
import uz.pdp.foodapp.models.TaomClass
import uz.pdp.foodapp.utils.MySharedPreferences

class ThirdActivity_MealsView : AppCompatActivity() {

    lateinit var gson: Gson
    private lateinit var mealsList: ArrayList<TaomClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_meals_view)
        gson = Gson()

        MySharedPreferences.init(this)

        //val meals = MySharedPreferences.meals

        if (MySharedPreferences.meals != "") {
            val type = object : TypeToken<ArrayList<TaomClass>>() {}.type
            val meals = gson.fromJson<ArrayList<TaomClass>>(MySharedPreferences.meals, type)
            mealsList = (meals)
            val myMealsAdapter = MyMealsAdapter(mealsList)
            list_item.adapter = myMealsAdapter

        }

        list_item.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, FourthActivity_MealDescription::class.java)
            intent.putExtra("meal" , mealsList[i])
            startActivity(intent)
        }

//        val type = object : TypeToken<ArrayList<TaomClass>>() {}.type
//        val mealList = gson.fromJson<ArrayList<TaomClass>>(meals, type)
//
//        if (mealList.size != null) {
//            val myMealsAdapter = MyMealsAdapter(mealList)
//
//        }

    }
}