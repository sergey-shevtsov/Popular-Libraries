package com.sshevtsov.popularlibraries.ui.counters

import com.sshevtsov.popularlibraries.model.CountersRepo

class CountersPresenter(private val countersRepo: CountersRepo) : Contract.Presenter {
    private var view: Contract.View? = null

    override fun onAttach(view: Contract.View) {
        this.view = view
        view.apply {
            setButtonOneText(countersRepo.getCurrent(OrderIndex.ZERO_INDEX.ordinal).toString())
            setButtonTwoText(countersRepo.getCurrent(OrderIndex.ONE_INDEX.ordinal).toString())
            setButtonThreeText(countersRepo.getCurrent(OrderIndex.TWO_INDEX.ordinal).toString())
        }
    }

    override fun onDetach() {
        view = null
    }

    override fun onButtonOneClick() {
        view?.setButtonOneText(countersRepo.next(OrderIndex.ZERO_INDEX.ordinal).toString())
    }

    override fun onButtonTwoClick() {
        view?.setButtonTwoText(countersRepo.next(OrderIndex.ONE_INDEX.ordinal).toString())
    }

    override fun onButtonThreeClick() {
        view?.setButtonThreeText(countersRepo.next(OrderIndex.TWO_INDEX.ordinal).toString())
    }
    
    private enum class OrderIndex {
        ZERO_INDEX, ONE_INDEX, TWO_INDEX
    }
}