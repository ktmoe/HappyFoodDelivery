package com.ktmmoe.happyfooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.activities.MyOrderActivity
import com.ktmmoe.happyfooddelivery.activities.RestaurantDetailActivity
import com.ktmmoe.happyfooddelivery.adapters.CategoriesAdapter
import com.ktmmoe.happyfooddelivery.adapters.RestaurantsAdapter
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.mvp.presenters.RestaurantsHomePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.impls.RestaurantsHomePresenterImpl
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantsHome0View
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantsHome1View
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantsHomeView
import kotlinx.android.synthetic.main.fragment_restaurants_1.*

private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantsFragment1 : BaseFragment(), RestaurantsHome1View {
    private lateinit var mPresenter: RestaurantsHomePresenter

    private lateinit var popularsAdapter: RestaurantsAdapter
    private lateinit var newsAdapter: RestaurantsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurants_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPresenter()
        setupActionListeners()
        setupRecyclers()

        mPresenter.onUiReady1(viewLifecycleOwner)
    }

    private fun setupPresenter() {
        mPresenter = getPresenter<RestaurantsHomePresenterImpl, RestaurantsHomeView>()
    }

    private fun setupActionListeners() {
        myOrder.setOnClickListener {
            mPresenter.onTapMyOrder()
        }
    }

    private fun setupRecyclers() {
        popularsAdapter = RestaurantsAdapter(1, mPresenter)
        newsAdapter = RestaurantsAdapter(2, mPresenter)

        recyclerViewPopulars.adapter = popularsAdapter
        recyclerViewNews.adapter = newsAdapter
        popularsAdapter.setNewData(listOf(RestaurantVO(), RestaurantVO(), RestaurantVO(), RestaurantVO(), RestaurantVO()))
        newsAdapter.setNewData(listOf(RestaurantVO(), RestaurantVO(), RestaurantVO(), RestaurantVO(), RestaurantVO()))
    }

    companion object {

        @JvmStatic
        fun newInstance() = RestaurantsFragment1()
    }

    override fun displayNewRestaurants(list: List<RestaurantVO>) {
        newsAdapter.setNewData(list)
    }

    override fun displayPopularRestaurants(list: List<RestaurantVO>) {
        popularsAdapter.setNewData(list)
    }

    override fun navigateToOrderScreen() {
        startActivity(MyOrderActivity.intent(requireContext()))
    }

    override fun navigateToRestaurantDetailScreen(vo: RestaurantVO) {
        startActivity(RestaurantDetailActivity.intent(requireContext(), vo))
    }

}