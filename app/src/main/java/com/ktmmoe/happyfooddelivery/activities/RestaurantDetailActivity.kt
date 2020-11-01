package com.ktmmoe.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.adapters.MenusAdapter
import com.ktmmoe.happyfooddelivery.adapters.PopularChoicesAdapter
import com.ktmmoe.happyfooddelivery.data.vos.MenuVO
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.load
import com.ktmmoe.happyfooddelivery.mvp.presenters.RestaurantDetailPresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.impls.RestaurantDetailPresenterImpl
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantDetailView
import com.ktmmoe.happyfooddelivery.utils.burgerShopCover
import kotlinx.android.synthetic.main.activity_restaurant_detail.*
import kotlinx.android.synthetic.main.activity_restaurant_detail.view.*

class RestaurantDetailActivity : BaseActivity(), RestaurantDetailView {

    private lateinit var mPresenter: RestaurantDetailPresenter

    private lateinit var mPopularChoicesAdapter: PopularChoicesAdapter
    private lateinit var mMenusAdapter: MenusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        setupPresenter()
        setupRecyclers()
        setupActionListeners()
        mPresenter.onPassedVoReceived(intent.getSerializableExtra("vo") as RestaurantVO)
    }

    private fun setupActionListeners() {
        gotoCart.setOnClickListener { mPresenter.onTapGoToCart() }
    }

    private fun setupRecyclers() {
        mPopularChoicesAdapter = PopularChoicesAdapter()
        mMenusAdapter = MenusAdapter(mPresenter)
        recyclerViewPopularChoices.adapter = mPopularChoicesAdapter
        recyclerViewMenus.adapter = mMenusAdapter

        mPopularChoicesAdapter.setNewData(listOf(MenuVO(), MenuVO(), MenuVO(), MenuVO(), MenuVO()))
        mMenusAdapter.setNewData(listOf(MenuVO(), MenuVO(), MenuVO(), MenuVO(), MenuVO()))
    }

    private fun setupPresenter(){
        mPresenter = getPresenter<RestaurantDetailPresenterImpl, RestaurantDetailView>()
    }

    override fun bindData(vo: RestaurantVO) {
        vo.cover.load(this, restaurantCover)
        estimateTime.text = vo.estimateTime
        restaurantTitle.text = vo.restaurantName
        rating.text = vo.rating.toString()
        address.text = vo.address

        mPopularChoicesAdapter.setNewData(vo.menus.filter { it.popular })
        mMenusAdapter.setNewData(vo.menus)
    }

    override fun increaseCartCount(count: Int) {
        gotoCart.visibility = if (count == 0) View.GONE
        else {
            gotoCart.text = String.format("Go To Cart %s", "$count")
            View.VISIBLE
        }
    }

    override fun navigateToCart() {
        startActivity(MyOrderActivity.intent(this))
    }

    companion object {
        fun intent(context: Context, restaurantVO: RestaurantVO): Intent = Intent(context, RestaurantDetailActivity::class.java)
                .apply {
                    putExtra("vo", restaurantVO)
                }
    }
}