package com.challenge.curve.vmorapp

import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle
import com.challenge.curve.vmorapp.di.DaggerVmorAppComponent
import com.challenge.curve.vmorapp.di.VmorAppComponent
import com.challenge.curve.vmorapp.di.VmorAppModule
import com.challenge.curve.vmorapp.lifecycle.ActivityLifecycleAdapter


/**
 * Main application.
 */
class VmorApplication : Application() {

    private lateinit var component: VmorAppComponent

    override fun onCreate() {
        super.onCreate()

        // Code to avoid orientation changes
        registerActivityLifecycleCallbacks(object : ActivityLifecycleAdapter() {
            override fun onActivityCreated(activity: Activity?, bundle: Bundle?) {
                super.onActivityCreated(activity, bundle)
                activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        })

        val module = VmorAppModule(MainActivityViewModel())
        component = DaggerVmorAppComponent.builder().vmorAppModule(module).build()
    }

    fun vmorAppComponent(): VmorAppComponent {
        return component
    }

}
