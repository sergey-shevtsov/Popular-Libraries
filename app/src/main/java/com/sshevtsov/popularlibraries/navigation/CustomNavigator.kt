package com.sshevtsov.popularlibraries.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sshevtsov.popularlibraries.R

class CustomNavigator(activity: FragmentActivity, container: Int) :
    AppNavigator(activity, container) {

    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        super.setupFragmentTransaction(screen, fragmentTransaction, currentFragment, nextFragment)
        currentFragment?.let {
            fragmentTransaction
                .setCustomAnimations(
                    R.animator.slide_in_top,
                    R.animator.slide_out_top,
                    R.animator.slide_in_top,
                    R.animator.slide_out_top
                )
        }
    }
}