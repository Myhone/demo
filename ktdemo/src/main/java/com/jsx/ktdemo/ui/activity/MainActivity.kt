package com.jsx.ktdemo.ui.activity

import android.os.Bundle
import com.jsx.ktdemo.R
import com.jsx.ktdemo.base.BaseActivity
import com.jsx.ktdemo.databinding.ActivityMainBinding
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel


/**
 * Created by wyq on 2021/7/6.
 *
 */
class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }
}