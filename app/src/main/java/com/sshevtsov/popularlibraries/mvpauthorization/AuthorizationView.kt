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
    fun showNoValidFieldError(fieldEnum: AuthorizationFieldEnum)

    @Skip
    fun showEmptyFieldError(fieldEnum: AuthorizationFieldEnum)

    @Skip
    fun cleanFieldError(fieldEnum: AuthorizationFieldEnum)

    @Skip
    fun requestFocusOnField(fieldEnum: AuthorizationFieldEnum)

    @Skip
    fun showKeyboard()

    @Skip
    fun hideKeyboard()

    @Skip
    fun clearFocus()
}