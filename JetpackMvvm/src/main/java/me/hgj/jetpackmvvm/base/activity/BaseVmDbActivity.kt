package me.hgj.jetpackmvvm.base.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/12
 * 描述　: 包含ViewModel 和DataBind ViewModelActivity基类，把ViewModel 和DataBind注入进来了
 * 需要使用DataBind的清继承它
 */
abstract class BaseVmDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM>() {

    lateinit var mDataBind: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        userDataBinding(true)
        super.onCreate(savedInstanceState)
    }

    /**
     * 创建DataBinding
     */
    override fun initDataBind() {
        mDataBind = DataBindingUtil.setContentView(this, layoutId())
        mDataBind.lifecycleOwner = this
    }
}