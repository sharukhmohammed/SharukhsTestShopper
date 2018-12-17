package test.sharukh.sharukhshopper.view.items

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_item.*
import test.sharukh.sharukhshopper.R
import test.sharukh.sharukhshopper.model.data.MyMart
import test.sharukh.sharukhshopper.presenter.ItemPresenter
import test.sharukh.sharukhshopper.view.cart.CartActivity

class ItemActivity : AppCompatActivity(), ItemPresenter.Interaction {

    lateinit var itemPresenter: ItemPresenter
    lateinit var items: List<MyMart.Category.Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)


        intent?.let {
            supportActionBar?.title = it.getStringExtra("TITLE")
            val items = it.getStringExtra("ITEMS")
            Log.w("SSSS","$items ++++++++++ $title")
            val itemType = object : TypeToken<List<MyMart.Category.Item>>() {}.type
            this.items = Gson().fromJson<List<MyMart.Category.Item>>(items, itemType)

            itemPresenter = ItemPresenter(this@ItemActivity)
            itemPresenter.setAllItems(this.items)

        }

    }

    override fun onItemAdded(item: MyMart.Category.Item) {
        Snackbar.make(item_recycler, "${item.name} added to cart", Snackbar.LENGTH_SHORT).show()
    }

    override fun onItemsSet(items: List<MyMart.Category.Item>) {
        item_recycler.adapter = ItemAdapter(items,this,itemPresenter)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.menu_cart -> {
                startActivity(Intent(this, CartActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
