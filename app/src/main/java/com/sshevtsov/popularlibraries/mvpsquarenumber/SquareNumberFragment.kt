package com.sshevtsov.popularlibraries.mvpsquarenumber

import android.os.Bundle
import android.view.View
import com.sshevtsov.popularlibraries.R
import com.sshevtsov.popularlibraries.databinding.FragmentSquareNumberBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SquareNumberFragment
    : MvpAppCompatFragment(R.layout.fragment_square_number), SquareNumberView {

    private val presenter by moxyPresenter { SquareNumberPresenter() }

    private var _binding: FragmentSquareNumberBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSquareNumberBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): SquareNumberFragment = SquareNumberFragment()
    }

}