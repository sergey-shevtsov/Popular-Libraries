package com.sshevtsov.popularlibraries.mvpgreetings

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface GreetingsView : MvpView {

    @SingleState
    fun showGreetings(login: String)
}