package com.jonathan.hostelbedcart

import android.app.Application

class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    companion object {
        private val TAG = BaseApplication::class.java.simpleName

        var instance: BaseApplication? = null
            private set


    }
}