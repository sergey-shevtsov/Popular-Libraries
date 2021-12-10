package com.sshevtsov.popularlibraries.mvpauthorization

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class AuthorizationPresenter(private val router: Router) : MvpPresenter<AuthorizationView>() {
}