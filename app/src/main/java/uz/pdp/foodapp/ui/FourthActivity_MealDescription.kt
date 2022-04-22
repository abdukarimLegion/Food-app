package uz.pdp.foodapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_fourth_meal_description.*
import uz.pdp.foodapp.R
import uz.pdp.foodapp.models.TaomClass
import uz.pdp.foodapp.utils.MySharedPreferences

class FourthActivity_MealDescription : AppCompatActivity() {

    private lateinit var mealList: ArrayList<TaomClass>
    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_meal_description)

        MySharedPreferences.init(this)
        gson = Gson()
        val intent = intent
        val serializableExtra = intent.getSerializableExtra("meal") as TaomClass
        meal_name.text = serializableExtra.mealName
        mahsulotlar.text = serializableExtra.mealItems
        tayyorlash.text = serializableExtra.mealDescriptions
    }
}