package com.sshevtsov.popularlibraries.impl

import com.sshevtsov.popularlibraries.model.CountersRepo
import com.sshevtsov.popularlibraries.ui.counters.CounterType

class CountersRepoImpl : CountersRepo {
    companion object {
        private const val COUNTER_ONE_INDEX = 0
        private const val COUNTER_TWO_INDEX = 1
        private const val COUNTER_THREE_INDEX = 2

        private const val COUNTER_ONE_START_VALUE = 0
        private const val COUNTER_TWO_START_VALUE = 0
        private const val COUNTER_THREE_START_VALUE = 0
    }

    private val counters =
        mutableListOf(COUNTER_ONE_START_VALUE, COUNTER_TWO_START_VALUE, COUNTER_THREE_START_VALUE)

    override fun getCurrent(counterType: CounterType): Int {
        return when (counterType) {
            CounterType.COUNTER_ONE -> counters[COUNTER_ONE_INDEX]
            CounterType.COUNTER_TWO -> counters[COUNTER_TWO_INDEX]
            CounterType.COUNTER_THREE -> counters[COUNTER_THREE_INDEX]
        }
    }

    override fun next(counterType: CounterType): Int {
        when (counterType) {
            CounterType.COUNTER_ONE -> {
                counters[COUNTER_ONE_INDEX]++
            }
            CounterType.COUNTER_TWO -> {
                counters[COUNTER_TWO_INDEX]++
            }
            CounterType.COUNTER_THREE -> {
                counters[COUNTER_THREE_INDEX]++
            }
        }
        return getCurrent(counterType)
    }

    override fun set(counterType: CounterType, value: Int) {
        when (counterType) {
            CounterType.COUNTER_ONE -> counters[COUNTER_ONE_INDEX] = value
            CounterType.COUNTER_TWO -> counters[COUNTER_TWO_INDEX] = value
            CounterType.COUNTER_THREE -> counters[COUNTER_THREE_INDEX] = value
        }
    }

}