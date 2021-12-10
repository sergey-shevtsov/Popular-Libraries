package com.sshevtsov.popularlibraries

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class App : Application() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigationHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        internal lateinit var instance: App
            private set
    }
}