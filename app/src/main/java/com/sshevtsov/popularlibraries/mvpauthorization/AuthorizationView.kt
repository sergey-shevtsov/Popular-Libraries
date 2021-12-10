package com.sshevtsov.popularlibraries.mvpauthorization

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface AuthorizationView : MvpView {

    @Skip
    fun showEmptyLoginError()

    @Skip
    fun showEmptyPasswordError()

    @Skip
    fun clearFocus()
}