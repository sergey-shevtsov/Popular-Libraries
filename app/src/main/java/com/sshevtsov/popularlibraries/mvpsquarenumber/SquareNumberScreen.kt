package com.sshevtsov.popularlibraries.mvpsquarenumber

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object SquareNumberScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        SquareNumberFragment.newInstance()
}