package uz.pdp.foodapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

object MySharedPreferences {

    private const val NAME = "meal"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences
    private val gson = Gson()

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    var meals: String?
        get() = preferences.getString("meal", "")
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("meal", value)
            }
        }
}