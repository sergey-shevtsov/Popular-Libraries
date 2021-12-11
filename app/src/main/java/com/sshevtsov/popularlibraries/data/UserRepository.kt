package com.sshevtsov.popularlibraries.data

import io.reactivex.rxjava3.core.Observable

interface UserRepository {

    fun getUserByLoginAndPassword(login: String, password: String): Observable<User>
}