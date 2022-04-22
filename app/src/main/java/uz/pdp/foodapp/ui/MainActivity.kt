package uz.pdp.foodapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import uz.pdp.foodapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu_btn.setOnClickListener {
            val intent = Intent(this, ThirdActivity_MealsView::class.java)
            startActivity(intent)

        }

        add_meal_btn.setOnClickListener {
            val intent = Intent(this, SecondActivity_add_meal::class.java)
            startActivity(intent)
        }
    }
}