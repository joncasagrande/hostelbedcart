package com.jonathan.hostelbedcart

import android.app.Application
import com.jonathan.hostelbedcart.module.viewModelModule
import com.jonathan.hostelbedcart.module.webModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Android context
            androidContext(this@BaseApplication)

            modules(listOf(webModule, viewModelModule))

        }

        instance = this

    }

    companion object {
        private val TAG = BaseApplication::class.java.simpleName

        var instance: BaseApplication? = null
            private set


    }
}