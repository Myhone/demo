package com.jsx.ktdemo.ui.activity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.blankj.utilcode.util.ToastUtils
import com.jsx.ktdemo.R
import com.jsx.ktdemo.base.BaseActivity
import com.jsx.ktdemo.databinding.ActivityMainBinding
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * Created by wyq on 2021/7/6.
 * MainActivity
 */
class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    var exitTime = 0L

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        //返回键监听
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val nav = Navigation.findNavController(this@MainActivity, R.id.host_fragment)
                if (nav.currentDestination != null && nav.currentDestination!!.id != R.id.mainFragment) {
                    //如果当前界面不是主页，那么直接调用返回即可
                    nav.navigateUp()
                } else {
                    //是主页
                    if (System.currentTimeMillis() - exitTime > 2000) {
                        ToastUtils.showShort("再按一次退出程序")
                        exitTime = System.currentTimeMillis()
                    } else {
                        finish()
                    }
                }
            }
        })
    }
}