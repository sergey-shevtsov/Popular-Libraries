package com.sshevtsov.popularlibraries.mvpauthorization

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.SingleState

interface AuthorizationView : MvpView {

    @OneExecution
    fun showEmptyLoginError()

    @OneExecution
    fun showEmptyPasswordError()
}