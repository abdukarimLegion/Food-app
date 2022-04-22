package uz.pdp.foodapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_second_add_meal.*
import uz.pdp.foodapp.R
import uz.pdp.foodapp.models.TaomClass
import uz.pdp.foodapp.utils.MySharedPreferences

class SecondActivity_add_meal : AppCompatActivity() {

    private lateinit var mealList: ArrayList<TaomClass>
    lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_add_meal)

        MySharedPreferences.init(this)

        gson = Gson()
        mealList = ArrayList()

        if (MySharedPreferences.meals != "") {
            val type = object : TypeToken<ArrayList<TaomClass>>() {}.type
            val contact2 = gson.fromJson<ArrayList<TaomClass>>(MySharedPreferences.meals, type)

            for (contact3 in contact2) {

                mealList.add(contact3)
            }
        }
        save_btn.setOnClickListener {
            val taom_nomi = taom_name_edit.text.toString()
            val masalliqlar = items_name_edit.text.toString()
            val tayyorlash = preparing_name_edit.text.toString()

            if(taom_nomi.trim().isNotEmpty()){
                if (masalliqlar.trim().isNotEmpty()){
                    if (tayyorlash.trim().isNotEmpty()){
                        val taomClass = TaomClass(taom_nomi, masalliqlar, tayyorlash)

                        mealList.add(taomClass)
                        val mealstr = gson.toJson(mealList)
                        MySharedPreferences.meals = mealstr
                        finish()
                    }else{
                        Toast.makeText(this, "Taom tayyorlash jarayonini to'ldiring!", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "Masalliqlarni to'ldiring!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Taom nomini to'ldiring!", Toast.LENGTH_SHORT).show()
            }




        }
    }
}