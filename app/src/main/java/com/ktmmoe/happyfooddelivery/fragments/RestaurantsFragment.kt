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
import com.ktmmoe.happyfooddelivery.data.vos.CategoryVO
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.mvp.presenters.RestaurantsHomePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.impls.RestaurantsHomePresenterImpl
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantsHome0View
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantsHomeView
import kotlinx.android.synthetic.main.fragment_restaurants_0.*

private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantsFragment : BaseFragment(), RestaurantsHome0View {
    private lateinit var mPresenter: RestaurantsHomePresenter

    private lateinit var categoryAdapter: CategoriesAdapter
    private lateinit var restaurantsAdapter: RestaurantsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurants_0, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPresenter()
        setupActionListeners()
        setupRecyclers()

        mPresenter.onUiReady(viewLifecycleOwner)
    }

    private fun setupPresenter(){
        mPresenter = getPresenter<RestaurantsHomePresenterImpl, RestaurantsHomeView>()
    }

    private fun setupActionListeners() {
        myOrder.setOnClickListener {
            mPresenter.onTapMyOrder()
        }
    }

    private fun setupRecyclers() {
        categoryAdapter = CategoriesAdapter()
        restaurantsAdapter = RestaurantsAdapter(0, mPresenter)

        recyclerViewCategory.adapter = categoryAdapter
        recyclerViewRestaurants.adapter = restaurantsAdapter
        categoryAdapter.setNewData(listOf(CategoryVO(), CategoryVO(), CategoryVO(), CategoryVO()))
        restaurantsAdapter.setNewData(listOf(RestaurantVO(), RestaurantVO(), RestaurantVO(), RestaurantVO(), RestaurantVO()))
    }

    companion object {
        @JvmStatic
        fun newInstance() = RestaurantsFragment()
    }

    override fun displayCategories(list: List<CategoryVO>) {
        categoryAdapter.setNewData(list)
    }

    override fun displayNewRestaurants(list: List<RestaurantVO>) {
        restaurantsAdapter.setNewData(list)
    }

    override fun navigateToOrderScreen() {
        startActivity(MyOrderActivity.intent(requireContext()))
    }

    override fun navigateToRestaurantDetailScreen(vo: RestaurantVO) {
        startActivity(RestaurantDetailActivity.intent(requireContext(), vo))
    }
}