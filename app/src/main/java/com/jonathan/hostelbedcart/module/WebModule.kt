package com.jonathan.hostelbedcart.module

import com.jonathan.hostelbedcart.rest.BaseAPI
import com.jonathan.hostelbedcart.rest.BaseHttp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(BaseHttp::class))
interface WebModule {
    fun inject(baseAPI: BaseAPI)

}
