package com.abyte.dagger2viewmodel

import com.abyte.dagger2viewmodel.modules.ActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class, ActivityModule::class])
interface GeeComponent : AndroidInjector<GeeApplication> {

}