package com.jsx.ktdemo.ui.weight.loadCallBack

import com.jsx.ktdemo.R
import com.kingja.loadsir.callback.Callback

class ErrorCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_error
    }

}