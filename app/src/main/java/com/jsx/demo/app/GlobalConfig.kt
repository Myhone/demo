package com.jsx.demo.app

import androidx.lifecycle.ViewModelProvider
import com.jsx.demo.base.ViewModelFactory
import com.jsx.demo.network.ExceptionHandle

/**
 *   @auther : Aleyn
 *   time   : 2019/11/12
 */
interface GlobalConfig {

    fun viewModelFactory(): ViewModelProvider.Factory? = ViewModelFactory.getInstance()

    fun globalExceptionHandle(e: Throwable) = ExceptionHandle.handleException(e)

}