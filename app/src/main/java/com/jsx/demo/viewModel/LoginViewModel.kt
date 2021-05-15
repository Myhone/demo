package com.jsx.demo.viewModel

import android.view.View
import androidx.navigation.Navigation
import com.jsx.demo.R
import com.jsx.demo.base.BaseViewModel

class LoginViewModel : BaseViewModel() {
    // TODO: Implement the ViewModel

    fun toLogin() {

    }

    val registerClickListener = View.OnClickListener {
        Navigation.findNavController(it)
            .navigate(R.id.action_loginFragment_to_registerFragment)
    }


    val resetPasswordClickListener = View.OnClickListener {
        Navigation.findNavController(it)
            .navigate(R.id.action_loginFragment_to_resetPasswordFragment)
    }
}