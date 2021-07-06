package com.jsx.demo.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jsx.demo.R
import com.jsx.demo.base.BaseActivity
import com.jsx.demo.base.BaseViewModel
import com.jsx.demo.base.NoViewModel
import com.jsx.demo.databinding.ActivityMainBinding


/**
 * Created by wyq on 2021/5/14.
 *
 */
class MainActivity : BaseActivity<NoViewModel, ActivityMainBinding>() {

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun initData() {
        TODO("Not yet implemented")
    }

}