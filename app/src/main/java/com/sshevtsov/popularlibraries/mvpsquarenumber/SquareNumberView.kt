package com.sshevtsov.popularlibraries.mvpsquarenumber

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface SquareNumberView : MvpView {

    @AddToEndSingle
    fun setResult(result: String)
}