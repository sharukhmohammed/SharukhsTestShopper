package test.sharukh.sharukhshopper.presenter

import test.sharukh.sharukhshopper.model.AppCart
import test.sharukh.sharukhshopper.model.data.MyMart

class ItemPresenter(val interaction: Interaction) {

    lateinit var items: List<MyMart.Category.Item>

    fun setAllItems(items: List<MyMart.Category.Item>) {
        this.items = items
        interaction.onItemsSet(items)
    }

    fun addToCart(item: MyMart.Category.Item) {
        if (item.count == 0) item.count++
        AppCart.addItem(item)
        interaction.onItemAdded(item)
    }

    interface Interaction {
        fun onItemAdded(item: MyMart.Category.Item)
        fun onItemsSet(items: List<MyMart.Category.Item>)
    }
}
