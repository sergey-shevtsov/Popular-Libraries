package com.sshevtsov.popularlibraries.impl

import com.sshevtsov.popularlibraries.model.CountersRepo

class CountersRepoImpl : CountersRepo {
    private val counters = mutableListOf(0, 0, 0)

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