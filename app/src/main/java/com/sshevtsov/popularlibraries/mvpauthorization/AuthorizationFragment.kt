package com.sshevtsov.popularlibraries.mvpauthorization

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import com.sshevtsov.popularlibraries.App
import com.sshevtsov.popularlibraries.R
import com.sshevtsov.popularlibraries.ViewState
import com.sshevtsov.popularlibraries.data.UserRepositoryFactory
import com.sshevtsov.popularlibraries.databinding.FragmentAuthorizationBinding
import com.sshevtsov.popularlibraries.mvpbase.InteractiveMvpAppCompatFragment
import moxy.ktx.moxyPresenter

class AuthorizationFragment
    : InteractiveMvpAppCompatFragment(R.layout.fragment_authorization), AuthorizationView {

    private val presenter by moxyPresenter {
        AuthorizationPresenter(UserRepositoryFactory.create(), App.instance.router)
    }

    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAuthorizationBinding.bind(view)

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
            presenter.onFieldTextChanged(AuthorizationFieldEnum.LOGIN)
        }

        binding.passwordEditText.doOnTextChanged { _, _, _, _ ->
            presenter.onFieldTextChanged(AuthorizationFieldEnum.PASSWORD)
        }

        binding.root.setOnClickListener {
            presenter.onEmptyAreaClicked()
        }
    }

    override fun setState(viewState: ViewState) {
        when (viewState) {
            ViewState.LOADING -> binding.loadingFrame.isVisible = true
            ViewState.IDLE -> binding.loadingFrame.isVisible = false
        }
    }

    override fun showIncorrectDataError() {
        Snackbar.make(binding.root, R.string.incorrect_data_error_text, Snackbar.LENGTH_LONG).show()
    }

    override fun showNoValidFieldError(fieldEnum: AuthorizationFieldEnum) {
        when (fieldEnum) {
            AuthorizationFieldEnum.LOGIN -> {
                binding.loginInputLayout.error = getString(R.string.no_valid_login_error_text)
            }
            AuthorizationFieldEnum.PASSWORD -> {
                binding.passwordInputLayout.error = getString(R.string.no_valid_password_error_text)
            }
        }
    }

    override fun showEmptyFieldError(fieldEnum: AuthorizationFieldEnum) {
        when (fieldEnum) {
            AuthorizationFieldEnum.LOGIN -> {
                binding.loginInputLayout.error = getString(R.string.empty_field_error_text)
            }
            AuthorizationFieldEnum.PASSWORD -> {
                binding.passwordInputLayout.error = getString(R.string.empty_field_error_text)
            }
        }
    }

    override fun cleanFieldError(fieldEnum: AuthorizationFieldEnum) {
        when (fieldEnum) {
            AuthorizationFieldEnum.LOGIN -> {
                binding.loginInputLayout.error = null
            }
            AuthorizationFieldEnum.PASSWORD -> {
                binding.passwordInputLayout.error = null
            }
        }
    }

    override fun requestFocusOnField(fieldEnum: AuthorizationFieldEnum) {
        when (fieldEnum) {
            AuthorizationFieldEnum.LOGIN -> {
                binding.loginEditText.requestFocus()
            }
            AuthorizationFieldEnum.PASSWORD -> {
                binding.passwordEditText.requestFocus()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): AuthorizationFragment = AuthorizationFragment()
    }
}