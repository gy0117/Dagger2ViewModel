package com.abyte.dagger2viewmodel.modules

import com.abyte.dagger2viewmodel.core.di.ActivityScope
import com.abyte.dagger2viewmodel.login.LoginActivity
import com.abyte.dagger2viewmodel.login.module.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun contributeLoginActivity(): LoginActivity

}