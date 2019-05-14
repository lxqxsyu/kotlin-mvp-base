package com.mvp.helloworld

import android.Manifest
import android.content.Intent
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Toast
import com.mvp.base.base.BaseActivity
import com.mvp.helloworld.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import pub.devrel.easypermissions.EasyPermissions

/**
 * 描述：
 * 日期：2019/5/14
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
class SplashActivity: BaseActivity() {

    private var alphaAnimation:AlphaAnimation?=null

    override fun layoutId(): Int = R.layout.activity_splash

    override fun initData() {

    }

    override fun initView() {


        //渐变展示启动屏
        alphaAnimation= AlphaAnimation(0.3f, 1.0f)
        alphaAnimation?.duration = 2000
        alphaAnimation?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(arg0: Animation) {
                redirectTo()
            }

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationStart(animation: Animation) {}

        })
        splashIcon.startAnimation(alphaAnimation)
        //checkPermission()
    }

    fun redirectTo() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * 6.0以下版本(系统自动申请) 不会弹框
     * 有些厂商修改了6.0系统申请机制，他们修改成系统自动申请权限了
     */
    private fun checkPermission(){
        val perms = arrayOf(Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        EasyPermissions.requestPermissions(this, "KotlinMvp应用需要以下权限，请允许", 0, *perms)
        toast("checkPermission")
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        toast("requestCode$requestCode")
        if (requestCode == 0) {
            if (perms.isNotEmpty()) {
                if (perms.contains(Manifest.permission.READ_PHONE_STATE)
                    && perms.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (alphaAnimation != null) {
                        splashIcon.startAnimation(alphaAnimation)
                    }
                }
            }
        }
    }
}