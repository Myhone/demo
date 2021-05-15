package com.jsx.demo.base

import android.app.Application
import android.content.Context

/**
 *   @auther : Aleyn
 *   time   : 2019/11/12
 */
open class BaseApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}