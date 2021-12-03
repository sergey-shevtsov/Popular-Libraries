package com.sshevtsov.popularlibraries.impl

import com.sshevtsov.popularlibraries.model.CountersRepo

class CountersRepoImpl : CountersRepo {
    companion object {
        private const val START_COUNTER_ONE_VALUE = 0
        private const val START_COUNTER_TWO_VALUE = 0
        private const val START_COUNTER_THREE_VALUE = 0
    }

    private val counters =
        mutableListOf(START_COUNTER_ONE_VALUE, START_COUNTER_TWO_VALUE, START_COUNTER_THREE_VALUE)

    override fun getCurrent(index: Int): Int {
        return counters[index]
    }

    override fun next(index: Int): Int {
        counters[index]++
        return getCurrent(index)
    }

    override fun set(index: Int, value: Int) {
        counters[index] = value
    }
}