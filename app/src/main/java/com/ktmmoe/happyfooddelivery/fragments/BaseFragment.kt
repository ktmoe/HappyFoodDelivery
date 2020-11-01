package com.ktmmoe.happyfooddelivery.fragments

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.ktmmoe.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.ktmmoe.happyfooddelivery.mvp.views.BaseView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
abstract class BaseFragment : Fragment(), BaseView {

    inline fun <reified T : AbstractBasePresenter<W>, reified W: BaseView> getPresenter(): T {
        val presenter = ViewModelProviders.of(this).get(T::class.java)
        if (this is W) presenter.initPresenter(this)
        return presenter
    }

    override fun showMessage(error: String) {
        Snackbar.make(requireView(), error, Snackbar.LENGTH_LONG).show()
    }
}