package com.abyte.dagger2viewmodel.login.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abyte.dagger2viewmodel.core.rx.RxViewModel
import com.abyte.dagger2viewmodel.login.repo.LoginRepository


class LoginViewModel(private val loginRepository: LoginRepository) : RxViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    private val _errorResult = MutableLiveData<String>()
    val errorResult: LiveData<String> = _errorResult

    fun login(userName: String, password: String) {
        register(
            loginRepository.createAuthorization()
                .subscribe({
                    if (it.token.isNotEmpty()) {
                        _loginResult.value = true
                    } else {
                        _errorResult.value = "token is empty"
                    }
                }, {
                    _errorResult.value = it.toString()
                })
        )
    }
}