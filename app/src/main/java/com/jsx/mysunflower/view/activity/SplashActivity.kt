package com.jsx.mysunflower.view.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.jsx.mysunflower.R
import com.jsx.mysunflower.databinding.ActivitySplashBinding

/**
 * Created by wyq on 2021/5/12.
 *
 */
class SplashActivity : AppCompatActivity() {

    private val REQUEST_CODE_PERMISSIONS = 101

    private val permissions = listOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivitySplashBinding>(
            this,
            R.layout.activity_splash
        ).activity = this

        requestPermissionsIfNecessary()
    }

    fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun requestPermissionsIfNecessary() {
        if (!checkAllPermissions()) {
            ActivityCompat.requestPermissions(
                this,
                permissions.toTypedArray(),
                REQUEST_CODE_PERMISSIONS
            )
        }
    }

    private fun checkAllPermissions(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            hasPermission = hasPermission and isPermissionGranted(permission)
        }
        return hasPermission
    }

    private fun isPermissionGranted(permission: String) =
        ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != REQUEST_CODE_PERMISSIONS)
            Toast.makeText(
                this,
                R.string.set_permissions_in_settings,
                Toast.LENGTH_LONG
            ).show()
    }
}