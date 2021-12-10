package com.sshevtsov.popularlibraries.mvpauthorization

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

interface AuthorizationView : MvpView {

    @OneExecution
    fun showEmptyLoginError()

    @OneExecution
    fun showEmptyPasswordError()
}