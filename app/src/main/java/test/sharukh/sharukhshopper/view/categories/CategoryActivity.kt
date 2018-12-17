package test.sharukh.sharukhshopper.view.categories

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.sharukh.sharukhshopper.R
import test.sharukh.sharukhshopper.model.data.MyMart
import test.sharukh.sharukhshopper.model.network.API
import test.sharukh.sharukhshopper.presenter.CategoryPresenter
import test.sharukh.sharukhshopper.view.cart.CartActivity

class CategoryActivity : AppCompatActivity(), CategoryPresenter.Interaction {


    lateinit var categoryPresenter: CategoryPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        categoryPresenter = CategoryPresenter(this@CategoryActivity)


        API()
            .getData()
            .enqueue(object : Callback<MyMart> {
                override fun onFailure(call: Call<MyMart>, t: Throwable) {
                    Toast.makeText(this@CategoryActivity, "Response Failed", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<MyMart>, response: Response<MyMart>) {
                    categoryPresenter.saveCategories(response.body()?.mymart!!)
                }

            })
    }


    override fun updateCategoryRecycler() {
        category_recycler.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        category_recycler.adapter = CategoryAdapter(categoryPresenter.categories, this@CategoryActivity)
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
                startActivity(Intent(this@CategoryActivity, CartActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
