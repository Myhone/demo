package com.jsx.ktdemo.ui.viewHolder

import android.view.View
import android.widget.ImageView
import coil.load
import com.jsx.ktdemo.R
import com.zhpan.bannerview.BaseViewHolder

/**
 * Created by wyq on 2021/7/6.
 *
 */
class WelcomeViewHolder(view: View) : BaseViewHolder<String>(view) {
    override fun bindData(data: String?, position: Int, pageSize: Int) {
        val imageView = findView<ImageView>(R.id.iv_welcome)
        imageView.load(data)
    }
}