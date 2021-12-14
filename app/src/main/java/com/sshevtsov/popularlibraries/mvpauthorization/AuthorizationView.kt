package com.sshevtsov.popularlibraries.mvpauthorization

import com.sshevtsov.popularlibraries.ViewState
import com.sshevtsov.popularlibraries.mvpinteractive.InteractiveMvpView
import moxy.viewstate.strategy.alias.Skip

interface AuthorizationView : InteractiveMvpView {

    @Skip
    fun setState(viewState: ViewState)

    @Skip
    fun showIncorrectDataError()

    @Skip
    fun showNoValidFieldError(fieldEnum: AuthorizationFieldEnum)

    @Skip
    fun showEmptyFieldError(fieldEnum: AuthorizationFieldEnum)

    @Skip
    fun cleanFieldError(fieldEnum: AuthorizationFieldEnum)

    @Skip
    fun requestFocusOnField(fieldEnum: AuthorizationFieldEnum)
}