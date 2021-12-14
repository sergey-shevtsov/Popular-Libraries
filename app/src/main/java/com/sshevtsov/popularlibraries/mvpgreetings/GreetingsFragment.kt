package com.sshevtsov.popularlibraries.mvpgreetings

import android.os.Bundle
import android.view.View
import com.sshevtsov.popularlibraries.R
import com.sshevtsov.popularlibraries.databinding.FragmentGreetingsBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class GreetingsFragment : MvpAppCompatFragment(R.layout.fragment_greetings), GreetingsView {

    private val login by lazy { arguments?.getString(ARG_USER_LOGIN).orEmpty() }

    private val presenter by moxyPresenter { GreetingsPresenter(login) }

    private var _binding: FragmentGreetingsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGreetingsBinding.bind(view)
    }

    override fun showGreetings(login: String) {
        binding.greetingsTextView.text =
            String.format("%s, %s!", "Hello", login)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(login: String): GreetingsFragment =
            GreetingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, login)
                }
            }
    }
}