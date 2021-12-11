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

        viewState.apply {
            setState(ViewState.LOADING)
            hideKeyboard()
            clearFocus()
        }

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

        var isValid = validateField(password, AuthorizationFieldEnum.PASSWORD)
        isValid = validateField(login, AuthorizationFieldEnum.LOGIN) && isValid

        return isValid
    }

    private fun validateField(text: String, fieldEnum: AuthorizationFieldEnum): Boolean {

        var errorType = ERROR_NONE

        val isValid = if (text.isBlank()) {
            errorType = ERROR_EMPTY
            false
        } else if (!text.matches(fieldEnum.regex)) {
            errorType = ERROR_NO_VALID
            false
        } else true

        doActionOnError(errorType, fieldEnum)

        return isValid
    }

    private fun doActionOnError(errorType: Int, fieldEnum: AuthorizationFieldEnum) {

        when (errorType) {
            ERROR_NONE -> {
                return
            }
            ERROR_EMPTY -> {
                viewState.showEmptyFieldError(fieldEnum)
            }
            ERROR_NO_VALID -> {
                viewState.showNoValidFieldError(fieldEnum)
            }
        }

        viewState.requestFocusOnField(fieldEnum)
        viewState.showKeyboard()
    }

    fun onFieldTextChanged(fieldEnum: AuthorizationFieldEnum) {
        viewState.cleanFieldError(fieldEnum)
    }

    fun onEmptyAreaClicked() {
        viewState.hideKeyboard()
        viewState.clearFocus()
    }

    companion object {
        private const val ERROR_NONE = 0
        private const val ERROR_EMPTY = 1
        private const val ERROR_NO_VALID = 2
    }
}