package test.sharukh.sharukhshopper.presenter

import test.sharukh.sharukhshopper.model.AppCart
import test.sharukh.sharukhshopper.model.data.MyMart

class CartPresenter (val interaction: Interaction){
    val appCart: AppCart = AppCart


    fun clearItems(){
        appCart.items = ArrayList()
        interaction.onItemClear()
    }

    fun getItems() : ArrayList<MyMart.Category.Item> {
        interaction.onItemsGot(appCart.items)
        return appCart.items
    }

    interface Interaction{
        fun onItemsGot(items: ArrayList<MyMart.Category.Item>)
        fun onItemClear()
    }
}