package com.jsx.ktdemo.ext

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import com.jsx.ktdemo.utils.SettingUtil
import me.hgj.jetpackmvvm.base.appContext

/**
 * Created by wyq on 2021/7/7.
 * 扩展函数(View的初始化等)
 */

fun ViewPager2.init(
    fragment: Fragment,
    fragments: ArrayList<Fragment>,
    isUserInputEnabled: Boolean
): ViewPager2 {
    this.isUserInputEnabled = isUserInputEnabled
    adapter = object : FragmentStateAdapter(fragment) {
        override fun getItemCount() = fragments.size
        override fun createFragment(position: Int) = fragments[position]
    }
    return this
}

fun BottomNavigationViewEx.init(navigationItemSelectedAction: (Int) -> Unit): BottomNavigationViewEx {
    enableAnimation(true)
    enableShiftingMode(false)
    enableItemShiftingMode(true)
    itemIconTintList = SettingUtil.getColorStateList(SettingUtil.getColor(appContext))
    itemTextColor = SettingUtil.getColorStateList(appContext)
    setTextSize(12F)
    setOnNavigationItemSelectedListener {
        navigationItemSelectedAction.invoke(it.itemId)
        true
    }
    return this
}