package com.jsx.mysunflower.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jsx.mysunflower.R
import com.jsx.mysunflower.databinding.ActivityLoginBinding


/**
 * Created by wyq on 2021/5/13.
 *
 */
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
    }


}