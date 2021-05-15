package com.jsx.demo.data

import com.jsx.demo.base.BaseModel
import com.jsx.demo.data.db.dao.HomeDao
import com.jsx.demo.data.http.HomeNetWork
import com.jsx.demo.network.BaseResult
import com.jsx.demo.network.entity.BannerBean
import com.jsx.demo.network.entity.HomeListBean
import com.jsx.demo.network.entity.NavTypeBean
import com.jsx.demo.network.entity.UsedWeb


/**
 *   @auther : Aleyn
 *   time   : 2019/10/29
 */
class HomeRepository private constructor(
    private val netWork: HomeNetWork,
    private val localData: HomeDao
) : BaseModel() {

    suspend fun getBannerData(refresh: Boolean = false): List<BannerBean> {
        return cacheNetCall({
            netWork.getBannerData()
        }, {
            localData.getBannerList()
        }, {
            if (refresh) localData.deleteBannerAll()
            localData.insertBanner(it)
        }, {
            !refresh && !it.isNullOrEmpty()
        })
    }

    suspend fun getHomeList(page: Int, refresh: Boolean): HomeListBean {
        return cacheNetCall({
            netWork.getHomeList(page)
        }, {
            localData.getHomeList(page + 1)
        }, {
            if (refresh) localData.deleteHomeAll()
            localData.insertData(it)
        }, {
            !refresh
        })
    }

    suspend fun getNaviJson(): BaseResult<List<NavTypeBean>> {
        return netWork.getNaviJson()
    }

    suspend fun getProjectList(page: Int, cid: Int): BaseResult<HomeListBean> {
        return netWork.getProjectList(page, cid)
    }

    suspend fun getPopularWeb(): BaseResult<MutableList<UsedWeb>> {
        return netWork.getPopularWeb()
    }

    companion object {

        @Volatile
        private var INSTANCE: HomeRepository? = null

        fun getInstance(netWork: HomeNetWork, homeDao: HomeDao) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: HomeRepository(netWork, homeDao).also { INSTANCE = it }
            }
    }
}