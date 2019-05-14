package com.mvp.helloworld.main

import android.os.Handler
import android.widget.Toast
import com.hazz.kotlinmvp.rx.scheduler.IoMainScheduler
import com.mvp.base.mvp.IPresenter
import com.mvp.base.mvp.MvpPresenter
import com.mvp.helloworld.HttpApiTool

/**
 * 描述：
 * 日期：2019/5/14
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
interface MainPresenter: IPresenter<MainView> {

    fun getTestData()

    abstract class BaseImpl: MvpPresenter<MainView>(), MainPresenter{

        override fun getTestData() {
            mRootView?.showLoading()
            //HttpApiTool.service.getTestData("").compose(IoMainScheduler()).subscribe {

            //}
            Handler().postDelayed(Runnable {
                mRootView?.showContent()
                mRootView?.loadNetImage("https://csdnimg.cn/pubfooter/images/csdn-cxrs.png")
            }, 3000)
        }
    }
}