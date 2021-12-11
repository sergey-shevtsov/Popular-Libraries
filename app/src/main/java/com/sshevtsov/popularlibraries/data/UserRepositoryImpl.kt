package com.sshevtsov.popularlibraries.data

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class UserRepositoryImpl : UserRepository {

    private val users = listOf(
        User("user1", "12345"),
        User("user2", "23456"),
        User("user3", "34567"),
        User("user4", "45678"),
        User("user5", "56789")
    )

    override fun getUserByLoginAndPassword(login: String, password: String): Observable<User> =
        Observable.just(users)
            .subscribeOn(Schedulers.io())
            .delay(1500L, TimeUnit.MILLISECONDS)
            .map { list -> list.first { user -> user.login == login && user.password == password } }
}