package com.ktmmoe.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.adapters.OrderItemsAdapter
import com.ktmmoe.happyfooddelivery.adapters.OrderRestaurantsAdapter
import com.ktmmoe.happyfooddelivery.data.vos.OrderItemVO
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.dialogs.CheckOutBottomSheetDialog
import com.ktmmoe.happyfooddelivery.load
import com.ktmmoe.happyfooddelivery.mvp.presenters.OrderPresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.impls.OrderPresenterImpl
import com.ktmmoe.happyfooddelivery.mvp.views.OrderView
import com.ktmmoe.happyfooddelivery.utils.thaiShopCover
import kotlinx.android.synthetic.main.activity_my_order.*

class MyOrderActivity : BaseActivity(), OrderView {
    private lateinit var mPresenter: OrderPresenter

    private lateinit var mOrderRestaurantsAdapter: OrderRestaurantsAdapter
    private lateinit var mOrderItemsAdapter: OrderItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_order)
        setSupportActionBar(myOrderToolbar)
        title = "My Order"

        setupPresenter()

        setupRecycler()
        setupActionListeners()
        mPresenter.onUiReady(this)
    }

    private fun setupPresenter() {
        mPresenter = getPresenter<OrderPresenterImpl, OrderView>()
    }

    private fun setupRecycler(){
        mOrderItemsAdapter = OrderItemsAdapter(mPresenter)
        mOrderRestaurantsAdapter = OrderRestaurantsAdapter()

        recyclerViewOrders.adapter = mOrderItemsAdapter
        orderHead.adapter = mOrderRestaurantsAdapter
        mOrderItemsAdapter.setNewData(listOf(OrderItemVO()))
        mOrderRestaurantsAdapter.setNewData(listOf(RestaurantVO()))
    }

    private fun setupActionListeners() {
        checkout.setOnClickListener { mPresenter.onTapCheckout() }
    }

    override fun hideEmptyView() {
        emptyOrder.visibility = View.GONE
        orderHead.visibility = View.VISIBLE
        orderBody.visibility = View.VISIBLE
    }

    override fun showEmptyView() {
        emptyOrder.visibility = View.VISIBLE
        orderHead.visibility = View.GONE
        orderBody.visibility = View.GONE
    }

    override fun showCheckoutDialog() {
        CheckOutBottomSheetDialog.newInstance()
                .show(supportFragmentManager, MyOrderActivity::class.java.simpleName)
    }

    override fun displayOrderItems(list: MutableList<OrderItemVO>) {
        var total = 0
        val restaurants = list.map {
            total += it.price * it.count
            RestaurantVO(restaurantName = it.restaurantName, rating = it.restaurantRating, address = it.restaurantAddress, cover = it.restaurantCover)
        }
        val distinct = restaurants.distinctBy { it.restaurantName }
        mOrderRestaurantsAdapter.setNewData(distinct)
        mOrderItemsAdapter.setNewData(list)

        subTotal.text = String.format("$${total}")
    }

    companion object {
        fun intent(context: Context) : Intent {
            return Intent(context, MyOrderActivity::class.java)
        }
    }
}