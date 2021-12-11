package com.sshevtsov.popularlibraries.data

object UserRepositoryFactory {

    fun create(): UserRepository = UserRepositoryImpl()
}