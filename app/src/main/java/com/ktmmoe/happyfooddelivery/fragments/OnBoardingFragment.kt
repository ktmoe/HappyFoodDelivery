package com.ktmmoe.happyfooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ktmmoe.happyfooddelivery.R
import kotlinx.android.synthetic.main.fragment_on_boarding.*

private const val ARG_PARAM1 = "param1"

class OnBoardingFragment : Fragment() {

    private var position: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titles = requireContext().resources.getStringArray(R.array.on_board_titles)
        val texts = requireContext().resources.getStringArray(R.array.on_board_texts)
        val images = arrayListOf(R.drawable.ic_on_boarding_1, R.drawable.ic_on_boarding_2, R.drawable.ic_on_boarding_3)

        onBoardingTitle.text = titles[this.position?:0]
        onBoardingText.text = texts[this.position?:0]
        onBoardingImage.setImageResource(images[position?:0])
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            OnBoardingFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, position)
                }
            }
    }
}