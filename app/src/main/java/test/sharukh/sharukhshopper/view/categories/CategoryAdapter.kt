package test.sharukh.sharukhshopper.view.categories

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_category.view.*
import test.sharukh.sharukhshopper.R
import test.sharukh.sharukhshopper.misc.GlideApp
import test.sharukh.sharukhshopper.model.data.MyMart
import test.sharukh.sharukhshopper.view.items.ItemActivity

class CategoryAdapter(val categories: List<MyMart.Category>, val context: Context) :
    RecyclerView.Adapter<CategoryAdapter.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return Holder(
            LayoutInflater.from(p0.context).inflate(R.layout.item_category, p0, false)
        )
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            GlideApp.with(context).load(categories[position].image).into(itemView.category_image)
            itemView.category_title.text = categories[position].name
            itemView.setOnClickListener {
                val intent = Intent(context,ItemActivity::class.java)
                intent.putExtra("TITLE",categories[position].name)
                intent.putExtra("ITEMS", Gson().toJson(categories[position].sublist))
                Log.w("AZZZ",Gson().toJson(categories[position].sublist))
                context.startActivity(intent)
            }
        }

    }
}

