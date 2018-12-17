package test.sharukh.sharukhshopper.model.data

data class MyMart(
    val mymart: List<Category>
) {
    data class Category(
        val image: String,
        val itemId: Int,
        val name: String,
        val sublist: List<Item>
    ) {
        data class Item(
            val name: String,
            val image: String,
            var count:Int = 1
        )
    }
}