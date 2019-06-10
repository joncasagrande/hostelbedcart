package com.jonathan.hostelbedcart.module

import com.jonathan.hostelbedcart.rest.BaseAPI
import com.jonathan.hostelbedcart.rest.BaseHttp
import org.koin.dsl.module

// just declare it
val webModule = module {
    // provided web components
    single { BaseAPI(get()) }
    single { BaseHttp() }

}
