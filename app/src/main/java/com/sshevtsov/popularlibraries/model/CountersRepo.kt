package com.sshevtsov.popularlibraries.model

interface CountersRepo {
    fun getCurrent(index: Int): Int
    fun next(index: Int): Int
    fun set(index: Int, value: Int)
}