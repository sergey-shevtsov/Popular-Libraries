package com.sshevtsov.popularlibraries.mvpsquarenumber

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.sshevtsov.popularlibraries.R
import com.sshevtsov.popularlibraries.databinding.FragmentSquareNumberBinding
import com.sshevtsov.popularlibraries.mvpinteractive.InteractiveMvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SquareNumberFragment
    : InteractiveMvpAppCompatFragment(R.layout.fragment_square_number), SquareNumberView {

    private val presenter by moxyPresenter { SquareNumberPresenter() }

    private var _binding: FragmentSquareNumberBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSquareNumberBinding.bind(view)

        initView()
    }

    private fun initView() {

        binding.countButton.setOnClickListener {
            presenter.onCountButtonClicked(binding.numberInputEditText.text.toString())
        }

        binding.numberInputEditText.doOnTextChanged { _, _, _, _ ->
            presenter.onFieldTextChanged()
        }

        binding.root.setOnClickListener {
            presenter.onEmptyAreaClicked()
        }
    }

    override fun setResult(result: String) {
        binding.resultTextView.text = result
    }

    override fun showEmptyFieldError() {
        binding.numberInputLayout.error = getString(R.string.empty_field_error_text)
    }

    override fun cleanFieldError() {
        binding.numberInputLayout.error = null
    }

    override fun requestFocusOnField() {
        binding.numberInputEditText.requestFocus()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): SquareNumberFragment = SquareNumberFragment()
    }

}