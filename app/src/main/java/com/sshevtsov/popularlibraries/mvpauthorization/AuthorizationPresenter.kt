package com.sshevtsov.popularlibraries.mvpauthorization

import com.github.terrakok.cicerone.Router
import com.sshevtsov.popularlibraries.ViewState
import com.sshevtsov.popularlibraries.data.UserRepository
import com.sshevtsov.popularlibraries.mvpgreetings.GreetingsScreen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter

class AuthorizationPresenter(
    private val userRepository: UserRepository,
    private val router: Router
) : MvpPresenter<AuthorizationView>() {

    fun onSignInButtonClicked(login: String, password: String) {

        if (!validateData(login, password)) return

        viewState.setState(ViewState.LOADING)
        viewState.clearFocus()

        userRepository.getUserByLoginAndPassword(login, password)
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { viewState.setState(ViewState.IDLE) }
            .subscribe({
                router.navigateTo(GreetingsScreen(login))
            }, {
                viewState.showIncorrectDataError()
            })
    }

    private fun validateData(login: String, password: String): Boolean {

        var isValid = true

        if (password.isBlank()) {
            viewState.showEmptyPasswordError()
            isValid = false
        }

        if (login.isBlank()) {
            viewState.showEmptyLoginError()
            isValid = false
        }

        return isValid
    }

    fun onEmptyAreaClicked() {
        viewState.clearFocus()
    }

}