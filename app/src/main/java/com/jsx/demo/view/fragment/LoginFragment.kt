package com.jsx.demo.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsx.demo.R
import com.jsx.demo.base.BaseFragment
import com.jsx.demo.databinding.FragmentLoginBinding
import com.jsx.demo.view.activity.MainActivity
import com.jsx.demo.viewModel.LoginViewModel

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun layoutId(): Int {
        return R.layout.fragment_login
    }

    override fun initView(savedInstanceState: Bundle?) {
        mBinding.viewModel = viewModel

        mBinding.btnLogin.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    MainActivity::class.java
                )
            )
            activity?.finish()
        }
    }


}