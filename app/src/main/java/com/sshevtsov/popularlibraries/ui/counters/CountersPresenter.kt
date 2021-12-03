package com.sshevtsov.popularlibraries.ui.counters

import com.sshevtsov.popularlibraries.model.CountersRepo

class CountersPresenter(private val countersRepo: CountersRepo) : Contract.Presenter {
    private var view: Contract.View? = null

    override fun onAttach(view: Contract.View) {
        this.view = view
        view.apply {
            setButtonOneText(countersRepo.getCurrent(0).toString())
            setButtonTwoText(countersRepo.getCurrent(1).toString())
            setButtonThreeText(countersRepo.getCurrent(2).toString())
        }
    }

    override fun onDetach() {
        view = null
    }

    override fun onButtonOneClick() {
        view?.setButtonOneText(countersRepo.next(0).toString())
    }

    override fun onButtonTwoClick() {
        view?.setButtonTwoText(countersRepo.next(1).toString())
    }

    override fun onButtonThreeClick() {
        view?.setButtonThreeText(countersRepo.next(2).toString())
    }
}