package com.jsx.ktdemo.ui.fragment.me

import android.os.Bundle
import com.jsx.ktdemo.R
import com.jsx.ktdemo.base.BaseFragment
import com.jsx.ktdemo.databinding.FragmentLoginBinding
import com.jsx.ktdemo.viewModel.LoginViewModel
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel


/**
 * Created by wyq on 2021/7/7.
 * 登录
 */
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_login
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    inner class PoxyClick {
        fun clear() {
            mViewModel.username.set("")
        }

        fun login(){
            when{
                mViewModel.username.get().isEmpty() -> {}
            }
        }
    }
}