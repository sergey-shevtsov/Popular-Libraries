package com.sshevtsov.popularlibraries.data

import io.reactivex.rxjava3.core.Observable

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
            .map { list -> list.first { user -> user.login == login && user.password == password } }
}