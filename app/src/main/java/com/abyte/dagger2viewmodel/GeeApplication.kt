package com.abyte.dagger2viewmodel


import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class GeeApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerGeeComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
    }
}
