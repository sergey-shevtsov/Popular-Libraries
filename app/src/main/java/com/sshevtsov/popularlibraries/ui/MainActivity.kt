package com.sshevtsov.popularlibraries.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sshevtsov.popularlibraries.R
import com.sshevtsov.popularlibraries.databinding.ActivityMainBinding
import com.sshevtsov.popularlibraries.ui.counters.CountersFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, CountersFragment())
                .commit()
        }
    }
}