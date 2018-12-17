package test.sharukh.sharukhshopper.model

import test.sharukh.sharukhshopper.model.data.MyMart

object AppCart {

    public var items: ArrayList<MyMart.Category.Item> = ArrayList()



    fun addItem(item: MyMart.Category.Item) {

        var isCountIncreased: Boolean = false

        for (i in items) {
            if (i.name.equals(item.name)) {
                i.count++
                isCountIncreased = true
            }
        }

        if (!isCountIncreased) items.add(item)
    }

}