package com.hazz.kotlinmvp.rx.scheduler

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 描述：主线程调度
 * 日期：2019/5/13
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
class IoMainScheduler<T> : BaseScheduler<T>(Schedulers.io(), AndroidSchedulers.mainThread())
