package com.jsx.mysunflower.app

import androidx.lifecycle.ViewModelProvider
import com.aleyn.mvvm.network.ExceptionHandle
import com.jsx.mysunflower.base.ViewModelFactory

/**
 *   @auther : Aleyn
 *   time   : 2019/11/12
 */
interface GlobalConfig {

    fun viewModelFactory(): ViewModelProvider.Factory? = ViewModelFactory.getInstance()

    fun globalExceptionHandle(e: Throwable) = ExceptionHandle.handleException(e)

}