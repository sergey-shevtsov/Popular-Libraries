package com.sshevtsov.popularlibraries.mvpmain

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.sshevtsov.popularlibraries.App
import com.sshevtsov.popularlibraries.R
import com.sshevtsov.popularlibraries.databinding.ActivityMainBinding
import com.sshevtsov.popularlibraries.navigation.CustomNavigator
import com.sshevtsov.popularlibraries.util.hideKeyboard
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val presenter by moxyPresenter { MainPresenter(App.instance.router) }

    private val navigator = CustomNavigator(this, R.id.fragment_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_app_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_square_number -> {
                presenter.onSquareNumberActionClicked()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun closeKeyboard() {
        hideKeyboard()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.instance.navigationHolder.removeNavigator()
        super.onPause()
    }
}