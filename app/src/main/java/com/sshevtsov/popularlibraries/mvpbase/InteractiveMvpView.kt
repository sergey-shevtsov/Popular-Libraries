package com.sshevtsov.popularlibraries.mvpbase

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface InteractiveMvpView : MvpView {

    @Skip
    fun showKeyboard()

    @Skip
    fun hideKeyboard()

    @Skip
    fun clearFocus()
}