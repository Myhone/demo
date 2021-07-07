package com.jsx.ktdemo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.jsx.ktdemo.R
import com.jsx.ktdemo.base.BaseActivity
import com.jsx.ktdemo.databinding.ActivityWelcomeBinding
import com.jsx.ktdemo.ui.adapter.WelcomeViewPageAdapter
import com.jsx.ktdemo.ui.viewHolder.WelcomeViewHolder
import com.jsx.ktdemo.utils.CacheUtil
import com.jsx.ktdemo.utils.SettingUtil
import com.zhpan.bannerview.BannerViewPager
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.view.gone
import me.hgj.jetpackmvvm.ext.view.visible

/**
 * Created by wyq on 2021/7/6.
 *
 */
class WelcomeActivity : BaseActivity<BaseViewModel, ActivityWelcomeBinding>() {

    private var imgList = arrayOf(
        "https://img1.baidu.com/it/u=1042337615,3058724003&fm=26&fmt=auto&gp=0.jpg",
        "https://img2.baidu.com/it/u=1716783366,3300459381&fm=26&fmt=auto&gp=0.jpg",
        "https://img2.baidu.com/it/u=1364574569,3070008364&fm=26&fmt=auto&gp=0.jpg"
    )
    private lateinit var viewPage: BannerViewPager<String, WelcomeViewHolder>

    override fun layoutId(): Int {
        return R.layout.activity_welcome
    }

    override fun initView(savedInstanceState: Bundle?) {
        mDataBind.click = ProxyClick()
        mDataBind.clBg.setBackgroundColor(SettingUtil.getColor(this))
        viewPage = findViewById(R.id.vp_banner)
        if (CacheUtil.isFirst()) {
            mDataBind.ivLogo.gone()
            viewPage.apply {
                adapter = WelcomeViewPageAdapter()
                setLifecycleRegistry(lifecycle)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        if (position == imgList.size - 1) {
                            mDataBind.tvGoMain.visible()
                        } else {
                            mDataBind.tvGoMain.gone()
                        }
                    }
                })
            }.create(imgList.toList())
        } else {
            mDataBind.ivLogo.visible()
            viewPage.postDelayed(Runnable {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 1000)
        }
    }

    inner class ProxyClick {
        fun toMain() {
            CacheUtil.setFirst(false)
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
            finish()
            //带点渐变动画
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}