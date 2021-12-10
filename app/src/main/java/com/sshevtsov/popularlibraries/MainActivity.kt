package com.sshevtsov.popularlibraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sshevtsov.popularlibraries.databinding.ActivityMainBinding
import com.sshevtsov.popularlibraries.mvpauthorization.AuthorizationScreen
import com.sshevtsov.popularlibraries.navigation.CustomNavigator

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val navigator = CustomNavigator(this, R.id.fragment_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) App.instance.router.navigateTo(AuthorizationScreen)
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