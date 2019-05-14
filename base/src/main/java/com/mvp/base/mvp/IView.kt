package com.mvp.base.mvp

import android.app.Activity
import android.content.Context
import android.support.annotation.LayoutRes
import com.classic.common.MultipleStatusView

/**
 * 描述：View基础接口定义
 * 日期：2019/5/13
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
interface IView {

    fun getActivity(): Activity

    fun getContext(): Context

    fun getMultipleStatuView():MultipleStatusView?

    fun showLoading()

    fun showEmpty()

    fun showNoNetwork()

    fun showContent()

    fun toastSuccess(message: String)

    fun toastFail(message: String)
}
