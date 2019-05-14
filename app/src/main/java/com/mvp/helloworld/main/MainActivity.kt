package com.mvp.helloworld.main

import android.Manifest
import android.app.Activity
import android.content.Context
import android.view.View
import com.classic.common.MultipleStatusView
import com.mvp.base.base.BaseActivity
import com.mvp.helloworld.R
import com.sunfusheng.GlideImageLoader
import com.sunfusheng.GlideImageView
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.EasyPermissions

class MainActivity : BaseActivity(){

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        mPresenter.getTestData()
    }

    override fun initView() {

    }

    private val mPresenter by lazy {
        object: MainPresenter.BaseImpl(){

        }
    }

    private val mView by lazy {
        object: MainView.BaseImpl(){
            override fun loadNetImage(url: String) {
                netimage.load(url)
            }

            override fun getMultipleStatuView(): MultipleStatusView? {
                return multipleStatusView
            }

            override fun changeUI() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getActivity(): Activity {
                return this@MainActivity
            }

            override fun getContext(): Context {
                return this@MainActivity
            }
        }
    }

    init {
        mPresenter.attachView(mView)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
