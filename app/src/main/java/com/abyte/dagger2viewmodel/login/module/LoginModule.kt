package com.abyte.dagger2viewmodel.login.module

import androidx.lifecycle.ViewModel
import com.abyte.dagger2viewmodel.core.di.ActivityScope
import com.abyte.dagger2viewmodel.core.di.ViewModelKey
import com.abyte.dagger2viewmodel.login.api.LoginApi
import com.abyte.dagger2viewmodel.login.repo.LoginRepository
import com.abyte.dagger2viewmodel.login.vm.LoginViewModel
import com.abyte.dagger2viewmodel.service.retrofit
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class LoginModule {

    @ActivityScope
    @Provides
    fun provideLoginApi(): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    @ActivityScope
    @Provides
    fun provideLoginRepository(loginApi: LoginApi): LoginRepository {
        return LoginRepository(loginApi)
    }

    @ActivityScope
    @Provides
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun provideLoginViewModel(loginRepository: LoginRepository): ViewModel {  // 这里返回ViewModel，不能返回LoginViewModel
        return LoginViewModel(loginRepository)
    }
}