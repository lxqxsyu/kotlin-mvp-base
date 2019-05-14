package com.mvp.helloworld

import com.mvp.base.net.RetrofitManager
import com.mvp.helloworld.entry.TestBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * 描述：
 * 日期：2019/5/14
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
object HttpApiTool {

    val service: ApiService by lazy (LazyThreadSafetyMode.SYNCHRONIZED){
        RetrofitManager.getRetrofit().create(ApiService::class.java)
    }

    interface ApiService{

        /**
         * 根据 nextPageUrl 请求数据下一页数据
         */
        @GET
        fun getTestData(@Url url: String): Observable<TestBean>
    }
}