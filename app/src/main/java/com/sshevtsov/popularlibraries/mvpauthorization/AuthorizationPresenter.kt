package com.sshevtsov.popularlibraries.mvpauthorization

import com.github.terrakok.cicerone.Router
import com.sshevtsov.popularlibraries.mvpgreetings.GreetingsScreen
import moxy.MvpPresenter

class AuthorizationPresenter(private val router: Router) : MvpPresenter<AuthorizationView>() {

    fun onSignInButtonClicked(login: String, password: String) {
        var validationPassed = true

        if (password.isBlank()) {
            viewState.showEmptyPasswordError()
            validationPassed = false
        }

        if (login.isBlank()) {
            viewState.showEmptyLoginError()
            validationPassed = false
        }

        if (validationPassed) router.navigateTo(GreetingsScreen(login))
    }

    fun onEmptyAreaClicked() {
        viewState.clearFocus()
    }

}