package com.ktmmoe.happyfooddelivery.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.load
import com.ktmmoe.happyfooddelivery.mvp.presenters.ProfilePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.impls.ProfilePresenterImpl
import com.ktmmoe.happyfooddelivery.mvp.views.ProfileView
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.IOException

class ProfileFragment : BaseFragment(), ProfileView {

    private lateinit var mPresenter: ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPresenter()
        mPresenter.onUiReady(requireActivity())
        setupActionListeners()
        editModeOff()
    }

    private fun setupActionListeners() {
        profileEdit.setOnClickListener { mPresenter.onTapEdit() }
        editCancel.setOnClickListener { mPresenter.onTapCancel() }
        editSave.setOnClickListener { mPresenter.onTapSave(etUsername.text.toString(), etEmail.text.toString()) }
        profileImage.setOnClickListener{ mPresenter.onTapUploadProfileImage() }
    }

    private fun setupPresenter(){
        mPresenter = getPresenter<ProfilePresenterImpl, ProfileView>()
    }

    override fun editModeOn() {
        editCancel.visibility = View.VISIBLE
        editSave.visibility = View.VISIBLE
        profileEdit.visibility = View.GONE

        etUsername.isEnabled = true
        etEmail.isEnabled = true
    }

    override fun editModeOff() {
        editCancel.visibility = View.GONE
        editSave.visibility = View.GONE
        profileEdit.visibility = View.VISIBLE

        etUsername.isEnabled = false
        etEmail.isEnabled = false
    }

    override fun updateProfileDisplay(name: String, email: String) {
        etUsername.setText(name)
        etEmail.setText(email)
    }

    override fun updateProfileImage(url: String) {
        url.load(requireContext(), profileImage)
    }

    override fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }
            val filePath = data.data
            try {
                filePath?.let {
                    if (Build.VERSION.SDK_INT >= 29) {
                        val source: ImageDecoder.Source =
                            ImageDecoder.createSource(requireContext().contentResolver, filePath)

                        val bitmap = ImageDecoder.decodeBitmap(source)
                        mPresenter.onProfileImageTaken(bitmap)
                    } else {
                        val bitmap = MediaStore.Images.Media.getBitmap(
                            requireContext().contentResolver, filePath
                        )
                        mPresenter.onProfileImageTaken(bitmap)
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        private const val PICK_IMAGE_REQUEST = 0
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}