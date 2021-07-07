package com.jsx.ktdemo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jsx.ktdemo.R
import com.jsx.ktdemo.base.BaseFragment
import com.jsx.ktdemo.databinding.FragmentMainBinding
import com.jsx.ktdemo.ext.init
import com.jsx.ktdemo.ui.fragment.home.HomeFragment
import com.jsx.ktdemo.ui.fragment.me.MeFragment
import com.jsx.ktdemo.ui.fragment.project.ProjectFragment
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * Created by wyq on 2021/7/7.
 * MainFragment
 */
class MainFragment : BaseFragment<BaseViewModel, FragmentMainBinding>() {

    private var fragments: ArrayList<Fragment> = arrayListOf()

    init {
        fragments.add(HomeFragment())
        fragments.add(ProjectFragment())
        fragments.add(MeFragment())
    }

    override fun layoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        //初始化ViewPager
        mDataBind.viewpager.init(this, fragments, false)
        //初始化BottomNavigation
        mDataBind.navigationBottom.init{
            when (it) {
                R.id.menu_home -> mDataBind.viewpager.setCurrentItem(0, false)
                R.id.menu_project -> mDataBind.viewpager.setCurrentItem(1, false)
                R.id.menu_me -> mDataBind.viewpager.setCurrentItem(2, false)
            }
        }
    }
}