package com.jsx.ktdemo.app

import com.tencent.mmkv.MMKV
import me.hgj.jetpackmvvm.base.BaseApp


/**
 * Created by wyq on 2021/7/6.
 *
 */
class App : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this.filesDir.absolutePath + "/mmkv")

    }
}