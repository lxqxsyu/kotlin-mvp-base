package com.mvp.base

import android.app.Application
import android.content.Context
import android.util.Log
import com.core.util.LogUtil
import com.core.util.toast.ToastUtil

/**
 * 描述：base模块的初始化代码（在application初始化）
 * 日期：2019/5/13
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
object BaseInit {

    lateinit var appContext: Context
    lateinit var app: Application

    fun init(app: Application){
        this.app = app
        appContext = app.applicationContext
        //设置日志等级
        LogUtil.init(null, Log.DEBUG)
        ToastUtil.initialize(appContext, ToastUtil.Mode.REPLACEABLE)
    }
}