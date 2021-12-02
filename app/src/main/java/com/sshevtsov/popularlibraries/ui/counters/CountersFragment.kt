package com.sshevtsov.popularlibraries.ui.counters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sshevtsov.popularlibraries.databinding.FragmentCountersBinding
import com.sshevtsov.popularlibraries.impl.CountersRepoImpl

class CountersFragment : Fragment(), Contract.View {
    private var _binding: FragmentCountersBinding? = null
    private val binding get() = _binding!!

    private val presenter: Contract.Presenter = CountersPresenter(CountersRepoImpl())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        initView()
    }

    private fun initView() {
        binding.apply {
            btnCounterOne.setOnClickListener { presenter.onButtonOneClick() }
            btnCounterTwo.setOnClickListener { presenter.onButtonTwoClick() }
            btnCounterThree.setOnClickListener { presenter.onButtonThreeClick() }
        }
    }

    override fun setButtonOneText(text: String) {
        binding.btnCounterOne.text = text
    }

    override fun setButtonTwoText(text: String) {
        binding.btnCounterTwo.text = text
    }

    override fun setButtonThreeText(text: String) {
        binding.btnCounterThree.text = text
    }

    override fun onDestroyView() {
        _binding = null
        presenter.onDetach()
        super.onDestroyView()
    }
}