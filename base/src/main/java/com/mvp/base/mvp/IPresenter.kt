package com.mvp.base.mvp



/**
 * 描述：Presenter基础接口定义
 * 日期：2019/5/13
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
interface IPresenter<in V: IView> {

    fun attachView(mRootView: V)

    fun detachView()

}
