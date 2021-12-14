package com.sshevtsov.popularlibraries.mvpinteractive

import com.sshevtsov.popularlibraries.util.clearFocus
import com.sshevtsov.popularlibraries.util.hideKeyboard
import com.sshevtsov.popularlibraries.util.showKeyboard
import moxy.MvpAppCompatFragment

abstract class InteractiveMvpAppCompatFragment(contentLayoutId: Int) :
    MvpAppCompatFragment(contentLayoutId), InteractiveMvpView {

    override fun showKeyboard() {
        requireActivity().showKeyboard()
    }

    override fun hideKeyboard() {
        requireActivity().hideKeyboard()
    }

    override fun clearFocus() {
        requireActivity().clearFocus()
    }
}