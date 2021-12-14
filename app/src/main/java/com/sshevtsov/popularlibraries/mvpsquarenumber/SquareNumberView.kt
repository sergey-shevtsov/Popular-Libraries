package com.sshevtsov.popularlibraries.mvpsquarenumber

import com.sshevtsov.popularlibraries.mvpinteractive.InteractiveMvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface SquareNumberView : InteractiveMvpView {

    @AddToEndSingle
    fun setResult(result: String)

    @Skip
    fun showEmptyFieldError()

    @Skip
    fun cleanFieldError()

    @Skip
    fun requestFocusOnField()
}