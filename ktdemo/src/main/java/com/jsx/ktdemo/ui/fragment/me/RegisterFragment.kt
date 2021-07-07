package com.jsx.ktdemo.ui.fragment.me

import android.os.Bundle
import com.jsx.ktdemo.R
import com.jsx.ktdemo.base.BaseFragment
import com.jsx.ktdemo.databinding.FragmentLoginBinding
import com.jsx.ktdemo.databinding.FragmentRegisterBinding
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel


/**
 * Created by wyq on 2021/7/7.
 * 注册
 */
class RegisterFragment : BaseFragment<BaseViewModel, FragmentRegisterBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_register
    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}