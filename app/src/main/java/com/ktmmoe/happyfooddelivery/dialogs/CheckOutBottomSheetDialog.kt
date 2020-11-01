package com.ktmmoe.happyfooddelivery.dialogs

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.mvp.presenters.CheckoutDialogPresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.impls.CheckoutDialogPresenterImpl
import com.ktmmoe.happyfooddelivery.mvp.views.CheckoutDialogView
import kotlinx.android.synthetic.main.bottom_sheet_checkout.*

/**
 * Created by ktmmoe on 31, October, 2020
 **/
class CheckOutBottomSheetDialog: BottomSheetDialogFragment(), CheckoutDialogView {
    private lateinit var mPresenter: CheckoutDialogPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_sheet_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPresenter()
        setupActionListeners()
    }

    private fun setupActionListeners() {
        dismiss.setOnClickListener { mPresenter.onTapDismiss() }
    }

    private fun setupPresenter() {
        mPresenter = ViewModelProviders.of(this).get(CheckoutDialogPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    companion object {
        fun newInstance() = CheckOutBottomSheetDialog()
    }

    override fun showMessage(error: String) {
        dismiss()
    }
}