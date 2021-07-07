package com.jsx.ktdemo.ui.fragment.project

import android.os.Bundle
import com.jsx.ktdemo.R
import com.jsx.ktdemo.base.BaseFragment
import com.jsx.ktdemo.databinding.FragmentProjectBinding
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel


/**
 * Created by wyq on 2021/7/7.
 * 项目主页
 */
class ProjectFragment : BaseFragment<BaseViewModel, FragmentProjectBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_project
    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}