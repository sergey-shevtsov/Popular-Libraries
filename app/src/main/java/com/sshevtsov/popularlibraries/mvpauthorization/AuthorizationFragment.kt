package com.sshevtsov.popularlibraries.mvpauthorization

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
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

        initView()
    }

    private fun initView() {
        binding.signInButton.setOnClickListener {
            presenter.onSignInButtonClicked(
                binding.loginEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }

        binding.loginEditText.doOnTextChanged { _, _, _, _ ->
            binding.loginInputLayout.error = null
        }

        binding.passwordEditText.doOnTextChanged { _, _, _, _ ->
            binding.passwordInputLayout.error = null
        }
    }

    override fun showEmptyLoginError() {
        binding.loginInputLayout.error = getString(R.string.empty_field_error_text)
        binding.loginEditText.requestFocus()
    }

    override fun showEmptyPasswordError() {
        binding.passwordInputLayout.error = getString(R.string.empty_field_error_text)
        binding.passwordEditText.requestFocus()
    }

    companion object {
        fun newInstance(): AuthorizationFragment = AuthorizationFragment()
    }
}