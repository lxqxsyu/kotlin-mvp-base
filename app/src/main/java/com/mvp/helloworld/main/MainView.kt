package com.mvp.helloworld.main

import android.app.Activity
import android.content.Context
import com.mvp.base.mvp.MvpView

/**
 * 描述：
 * 日期：2019/5/14
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
interface MainView: MvpView {

    fun changeUI()

    fun loadNetImage(url: String)

    abstract class BaseImpl: MvpView.MultipleStatuView(), MainView{

        override fun toastFail(message: String) {

        }

        override fun toastSuccess(message: String) {

        }
    }
}