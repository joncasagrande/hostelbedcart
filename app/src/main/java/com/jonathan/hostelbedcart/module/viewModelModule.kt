package com.jonathan.hostelbedcart.module

import com.jonathan.hostelbedcart.rest.BaseAPI
import com.jonathan.hostelbedcart.rest.BaseHttp
import com.jonathan.hostelbedcart.viewmodel.MainActivityViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainActivityViewModel() }

}