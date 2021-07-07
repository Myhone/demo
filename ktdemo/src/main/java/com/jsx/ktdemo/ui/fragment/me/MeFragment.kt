package com.jsx.ktdemo.ui.fragment.me

import android.os.Bundle
import com.jsx.ktdemo.R
import com.jsx.ktdemo.base.BaseFragment
import com.jsx.ktdemo.databinding.FragmentMeBinding
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel


/**
 * Created by wyq on 2021/7/7.
 * 我的主页
 */
class MeFragment : BaseFragment<BaseViewModel, FragmentMeBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_me
    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}