package com.sshevtsov.popularlibraries.ui.counters

class Contract {
    interface View {
        fun setButtonOneText(text: String)
        fun setButtonTwoText(text: String)
        fun setButtonThreeText(text: String)
    }

    interface Presenter {
        fun onAttach(view: View)
        fun onDetach()

        fun onButtonOneClick()
        fun onButtonTwoClick()
        fun onButtonThreeClick()
    }
}