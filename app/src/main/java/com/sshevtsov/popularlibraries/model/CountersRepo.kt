package com.sshevtsov.popularlibraries.model

import com.sshevtsov.popularlibraries.ui.counters.CounterType

interface CountersRepo {
    fun getCurrent(counterType: CounterType): Int
    fun next(counterType: CounterType): Int
    fun set(counterType: CounterType, value: Int)
}