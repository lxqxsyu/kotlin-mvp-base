package com.mvp.helloworld

import android.app.Application
import com.jeremyliao.liveeventbus.LiveEventBus
import com.mvp.base.BaseInit

/**
 * 描述：
 * 日期：2019/5/13
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
class CustomeApplication : Application() {

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        BaseInit.init(this)
        LiveEventBus.get()
            .config()
            .supportBroadcast(this)
            .lifecycleObserverAlwaysActive(true)
    }
}