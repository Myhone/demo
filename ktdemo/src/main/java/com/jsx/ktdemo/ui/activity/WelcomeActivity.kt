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
        "https://wanandroid.com/blogimgs/31c2394c-b07c-4699-afd1-95aa7a3bebc6.png",
        "https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png",
        "https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png"
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

            viewPage.postDelayed(Runnable {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 300)
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