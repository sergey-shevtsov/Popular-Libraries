package com.sshevtsov.popularlibraries.ui.counters

import com.sshevtsov.popularlibraries.model.CountersRepo

class CountersPresenter(private val countersRepo: CountersRepo) : Contract.Presenter {
    private var view: Contract.View? = null

    override fun onAttach(view: Contract.View) {
        this.view = view
        val counterTypes = CounterType.values()
        for (counterType in counterTypes) {
            view.setCounterButtonText(
                counterType,
                countersRepo.getCurrent(counterType).toString()
            )
        }
    }

    override fun onDetach() {
        view = null
    }

    override fun onCounterButtonClick(counterType: CounterType) {
        view?.setCounterButtonText(
            counterType,
            countersRepo.next(counterType).toString()
        )
    }
}