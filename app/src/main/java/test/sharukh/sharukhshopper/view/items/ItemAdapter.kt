package test.sharukh.sharukhshopper.view.items

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_item.view.*
import test.sharukh.sharukhshopper.R
import test.sharukh.sharukhshopper.misc.GlideApp
import test.sharukh.sharukhshopper.model.AppCart
import test.sharukh.sharukhshopper.model.data.MyMart
import test.sharukh.sharukhshopper.presenter.ItemPresenter

class ItemAdapter(val items: List<MyMart.Category.Item>, val context: Context, val itemPresenter: ItemPresenter) :
    RecyclerView.Adapter<ItemAdapter.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return Holder(
            LayoutInflater.from(p0.context).inflate(R.layout.item_item, p0, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            GlideApp.with(context).load(items[position].image).into(itemView.item_image)
            itemView.item_name.text = items[position].name
            itemView.item_add_to_cart.setOnClickListener {
                itemPresenter.addToCart(items[position])
            }
        }

    }
}

