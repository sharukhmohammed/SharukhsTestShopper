package test.sharukh.sharukhshopper.presenter

import test.sharukh.sharukhshopper.model.data.MyMart

class CategoryPresenter(val interaction: Interaction) {
     lateinit var categories: List<MyMart.Category>

    fun saveCategories(categories: List<MyMart.Category>) {
        this.categories = categories
        interaction.updateCategoryRecycler()
    }

    interface Interaction {
        fun updateCategoryRecycler()
    }

}