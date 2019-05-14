package com.mvp.base.mvp

import android.app.Activity
import com.classic.common.MultipleStatusView

/**
 * 描述：对外暴露的MvpView
 * 日期：2019/5/14
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
interface MvpView: IView {

    override fun getMultipleStatuView(): MultipleStatusView? {
        return null;
    }

    abstract class MultipleStatuView: MvpView{

        private fun checkHasMultipleView(){
            if(getMultipleStatuView() == null){
                throw LayoutNoMultipleStatuView()
            }
        }

        override fun showLoading() {
            checkHasMultipleView()
            getMultipleStatuView()?.showLoading()
        }

        override fun showEmpty() {
            checkHasMultipleView()
            getMultipleStatuView()?.showEmpty()
        }

        override fun showNoNetwork() {
            checkHasMultipleView()
            getMultipleStatuView()?.showNoNetwork()
        }

        override fun showContent() {
            checkHasMultipleView()
            getMultipleStatuView()?.showContent()
        }

        private class LayoutNoMultipleStatuView internal constructor() : RuntimeException("Please add MultipleStatuView before" + " call showXxxx Method")
    }
}