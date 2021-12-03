package com.sshevtsov.popularlibraries.ui.counters

import com.sshevtsov.popularlibraries.model.CountersRepo

class CountersPresenter(private val countersRepo: CountersRepo) : Contract.Presenter {
    private var view: Contract.View? = null

    override fun onAttach(view: Contract.View) {
        this.view = view
        view.setCounterButtonText(
            CounterType.COUNTER_ONE,
            countersRepo.getCurrent(CounterType.COUNTER_ONE.ordinal).toString()
        )
        view.setCounterButtonText(
            CounterType.COUNTER_TWO,
            countersRepo.getCurrent(CounterType.COUNTER_TWO.ordinal).toString()
        )
        view.setCounterButtonText(
            CounterType.COUNTER_THREE,
            countersRepo.getCurrent(CounterType.COUNTER_THREE.ordinal).toString()
        )
    }

    override fun onDetach() {
        view = null
    }

    override fun onCounterButtonClick(counterType: CounterType) {
        view?.setCounterButtonText(
            counterType,
            countersRepo.next(counterType.ordinal).toString()
        )
    }
}