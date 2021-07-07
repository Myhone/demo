package com.jsx.ktdemo.viewmodel

import android.view.View
import androidx.databinding.ObservableInt
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.callback.databind.BooleanObservableField
import me.hgj.jetpackmvvm.callback.databind.StringObservableField


/**
 * Created by wyq on 2021/7/7.
 * 登录VM
 */
class LoginViewModel : BaseViewModel() {
    //用户名
    var username = StringObservableField()

    //密码(登录注册界面)
    var password = StringObservableField()

    var password2 = StringObservableField()

    //是否显示明文密码（登录注册界面）
    var isShowPwd = BooleanObservableField()

    var isShowPwd2 = BooleanObservableField()

    //判断用户名清除按钮是否显示
    var clearVisible = object : ObservableInt(username) {
        override fun get() = if (username.get().isEmpty()) View.GONE else View.VISIBLE
    }

    var passwordVisible = object : ObservableInt(password){
        override fun get() = if (password.get().isEmpty()) View.GONE else View.VISIBLE
    }

    var password2Visible = object : ObservableInt(password2){
        override fun get() = if (password2.get().isEmpty()) View.GONE else View.VISIBLE
    }
}