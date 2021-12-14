package com.sshevtsov.popularlibraries.mvpmain

import android.view.Menu
import android.view.MenuItem
import com.sshevtsov.popularlibraries.App
import com.sshevtsov.popularlibraries.R
import com.sshevtsov.popularlibraries.navigation.CustomNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    private val presenter by moxyPresenter { MainPresenter(App.instance.router) }

    private val navigator = CustomNavigator(this, R.id.fragment_container)

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

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.instance.navigationHolder.removeNavigator()
        super.onPause()
    }
}