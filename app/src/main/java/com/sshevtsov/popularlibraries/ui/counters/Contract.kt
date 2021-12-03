package com.sshevtsov.popularlibraries.ui.counters

class Contract {
    interface View {
        fun initView()
        fun setCounterButtonText(counterType: CounterType, text: String)
    }

    interface Presenter {
        fun onAttach(view: View)
        fun onDetach()

        fun onCounterButtonClick(counterType: CounterType)
    }
}