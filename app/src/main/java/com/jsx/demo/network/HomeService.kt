package com.jsx.demo.network

import com.jsx.demo.network.entity.BannerBean
import com.jsx.demo.network.entity.HomeListBean
import com.jsx.demo.network.entity.NavTypeBean
import com.jsx.demo.network.entity.UsedWeb

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *   @auther : Aleyn
 *   time   : 2019/10/29
 */
interface HomeService {

    /**
     * 玩安卓轮播图
     */
    @GET("banner/json")
    suspend fun getBanner(): BaseResult<List<BannerBean>>


    /**
     * 导航数据
     */
    @GET("project/tree/json")
    suspend fun naviJson(): BaseResult<List<NavTypeBean>>


    /**
     * 项目列表
     * @param page 页码，从0开始
     */
    @GET("article/listproject/{page}/json")
    suspend fun getHomeList(@Path("page") page: Int): BaseResult<HomeListBean>


    /**
     * 项目列表
     * @param page 页码，从0开始
     */
    @GET("project/list/{page}/json")
    suspend fun getProjectList(@Path("page") page: Int, @Query("cid") cid: Int): BaseResult<HomeListBean>


    /**
     * 常用网站
     */
    @GET("friend/json")
    suspend fun getPopularWeb(): BaseResult<MutableList<UsedWeb>>
}