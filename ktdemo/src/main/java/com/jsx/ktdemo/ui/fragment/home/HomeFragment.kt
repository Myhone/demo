package com.jsx.ktdemo.ui.fragment.home

import android.os.Bundle
import com.jsx.ktdemo.R
import com.jsx.ktdemo.base.BaseFragment
import com.jsx.ktdemo.databinding.FragmentHomeBinding
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel


/**
 * Created by wyq on 2021/7/7.
 *
 */
class HomeFragment : BaseFragment<BaseViewModel, FragmentHomeBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}