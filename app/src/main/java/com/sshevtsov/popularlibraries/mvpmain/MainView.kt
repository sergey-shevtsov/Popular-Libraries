package com.sshevtsov.popularlibraries.mvpmain

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface MainView : MvpView {

    @Skip
    fun closeKeyboard()
}