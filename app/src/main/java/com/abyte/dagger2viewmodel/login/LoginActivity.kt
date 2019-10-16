package com.abyte.dagger2viewmodel.login

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.abyte.dagger2viewmodel.R
import com.abyte.dagger2viewmodel.base.BaseActivity
import com.abyte.dagger2viewmodel.core.di.ViewModelFactory
import com.abyte.dagger2viewmodel.login.vm.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk15.listeners.onClick
import javax.inject.Inject

class LoginActivity : BaseActivity() {

    private lateinit var mLoginViewModel: LoginViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLoginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
        mLoginViewModel.apply {

            loginResult.observe(this@LoginActivity, Observer {
                Toast.makeText(this@LoginActivity, "登录成功", Toast.LENGTH_SHORT).show()
            })

            errorResult.observe(this@LoginActivity, Observer {
                Toast.makeText(this@LoginActivity, "失败：$it", Toast.LENGTH_SHORT).show()
            })
        }
        initView()

    }

    private fun initView() {
        loginSubmit.onClick {
            mLoginViewModel.login("johnnyswordman", "123456")
        }
    }
}
