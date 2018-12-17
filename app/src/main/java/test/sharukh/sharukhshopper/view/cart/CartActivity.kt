package test.sharukh.sharukhshopper.view.cart

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cart.*
import test.sharukh.sharukhshopper.R
import test.sharukh.sharukhshopper.model.data.MyMart
import test.sharukh.sharukhshopper.presenter.CartPresenter

class CartActivity : AppCompatActivity(), CartPresenter.Interaction {


    lateinit var cartPresenter: CartPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        cartPresenter = CartPresenter(this@CartActivity)

        cartPresenter.getItems()

        checkout_cart.setOnClickListener {
            Snackbar.make(checkout_cart, "Proceed to Checkout", Snackbar.LENGTH_SHORT).show()
        }

        clear_cart.setOnClickListener {
            cartPresenter.clearItems()
        }

    }

    override fun onItemsGot(items: ArrayList<MyMart.Category.Item>) {
        cart_recycler.adapter = CartAdapter(this)
    }

    override fun onItemClear() {
        Snackbar.make(checkout_cart, "Cart Items Cleared", Snackbar.LENGTH_SHORT).show()
        cartPresenter.getItems()
    }
}
