package com.sshevtsov.popularlibraries.mvpinteractive

import com.sshevtsov.popularlibraries.util.clearFocus
import com.sshevtsov.popularlibraries.util.hideKeyboard
import com.sshevtsov.popularlibraries.util.showKeyboard
import moxy.MvpAppCompatFragment

abstract class InteractiveMvpAppCompatFragment(contentLayoutId: Int) :
    MvpAppCompatFragment(contentLayoutId) {

    fun showKeyboard() {
        requireActivity().showKeyboard()
    }

    fun hideKeyboard() {
        requireActivity().hideKeyboard()
    }

    fun clearFocus() {
        requireActivity().clearFocus()
    }
}