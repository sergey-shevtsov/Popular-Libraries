package com.sshevtsov.popularlibraries.mvpgreetings

import moxy.MvpPresenter

class GreetingsPresenter(private val login: String) : MvpPresenter<GreetingsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showGreetings(login)
    }
}