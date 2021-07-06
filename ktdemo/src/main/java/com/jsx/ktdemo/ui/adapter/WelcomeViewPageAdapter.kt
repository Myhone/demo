package com.jsx.ktdemo.ui.adapter

import android.view.View
import com.jsx.ktdemo.R
import com.jsx.ktdemo.ui.viewHolder.WelcomeViewHolder
import com.zhpan.bannerview.BaseBannerAdapter


/**
 * Created by wyq on 2021/7/6.
 *
 */
class WelcomeViewPageAdapter : BaseBannerAdapter<String, WelcomeViewHolder>() {

    override fun createViewHolder(itemView: View, viewType: Int): WelcomeViewHolder {
        return WelcomeViewHolder(itemView)
    }

    override fun onBind(holder: WelcomeViewHolder?, data: String?, position: Int, pageSize: Int) {
        holder?.bindData(data, position, pageSize)
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_vp_welcome
    }
}