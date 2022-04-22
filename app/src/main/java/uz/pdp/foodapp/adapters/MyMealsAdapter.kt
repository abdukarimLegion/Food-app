package uz.pdp.foodapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item.view.*
import uz.pdp.foodapp.R
import uz.pdp.foodapp.models.TaomClass

class MyMealsAdapter(var list: List<TaomClass>) : BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var itemView : View

        if (p1 == null){
            itemView = LayoutInflater.from(p2?.context).inflate(R.layout.item, p2 , false)
        }else{
            itemView = p1
        }

        itemView.item_name.text = list[p0].mealName

        return itemView
    }

}