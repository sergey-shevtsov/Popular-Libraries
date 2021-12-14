package com.sshevtsov.popularlibraries.mvpmain

import com.github.terrakok.cicerone.Router
import com.sshevtsov.popularlibraries.mvpauthorization.AuthorizationScreen
import com.sshevtsov.popularlibraries.mvpsquarenumber.SquareNumberScreen
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(AuthorizationScreen)
    }

    fun onSquareNumberActionClicked() {
        router.navigateTo(SquareNumberScreen)
    }
}