package com.abyte.dagger2viewmodel.login.repo

import com.abyte.dagger2viewmodel.login.api.LoginApi
import com.abyte.dagger2viewmodel.model.AuthorizationRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginRepository(private val loginApi: LoginApi) {

    fun createAuthorization() =
        loginApi
            .createAuthorization(AuthorizationRequest())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}