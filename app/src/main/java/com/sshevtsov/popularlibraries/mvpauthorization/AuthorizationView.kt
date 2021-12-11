package com.sshevtsov.popularlibraries.mvpauthorization

import com.sshevtsov.popularlibraries.ViewState
import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface AuthorizationView : MvpView {

    @Skip
    fun setState(viewState: ViewState)

    @Skip
    fun showIncorrectDataError()

    @Skip
    fun showEmptyLoginError()

    @Skip
    fun showEmptyPasswordError()

    @Skip
    fun clearFocus()
}