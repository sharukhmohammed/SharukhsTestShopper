package test.sharukh.sharukhshopper.view.cart

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_cart.view.*
import test.sharukh.sharukhshopper.R
import test.sharukh.sharukhshopper.misc.GlideApp
import test.sharukh.sharukhshopper.model.AppCart
import test.sharukh.sharukhshopper.presenter.CartPresenter

class CartAdapter(val context: Context) :
    RecyclerView.Adapter<CartAdapter.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return Holder(
            LayoutInflater.from(p0.context).inflate(R.layout.item_cart, p0, false)
        )
    }

    override fun getItemCount(): Int {
        return AppCart.items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            GlideApp.with(context).load(AppCart.items[position].image).into(itemView.item_image)
            itemView.item_name.text = AppCart.items[position].name
            itemView.item_count.text = AppCart.items[position].count.toString()
        }

    }
}

