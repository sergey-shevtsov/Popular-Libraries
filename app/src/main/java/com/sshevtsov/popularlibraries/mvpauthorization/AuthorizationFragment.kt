package com.sshevtsov.popularlibraries.mvpauthorization

import android.os.Bundle
import android.view.View
import com.sshevtsov.popularlibraries.App
import com.sshevtsov.popularlibraries.R
import com.sshevtsov.popularlibraries.databinding.FragmentAuthorizationBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class AuthorizationFragment
    : MvpAppCompatFragment(R.layout.fragment_authorization), AuthorizationView {

    private val presenter by moxyPresenter { AuthorizationPresenter(App.instance.router) }

    private lateinit var binding: FragmentAuthorizationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthorizationBinding.bind(view)
    }

    companion object {
        fun newInstance(): AuthorizationFragment = AuthorizationFragment()
    }
}