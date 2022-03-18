package com.archtecture_sample.learn.todoapp.tasks.data

import com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar.CalendarData
import com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar.FestivalInfo
import com.ddzx.base_module.config.BaseConfig
import com.ddzx.base_module.data.error.DEFAULT_ERROR
import com.ddzx.base_module.data.error.NETWORK_ERROR
import com.ddzx.base_module.data.error.NO_INTERNET_CONNECTION
import com.ddzx.base_module.data.remote.Resource
import com.ddzx.base_module.data.remote.ServiceGenerator
import com.ddzx.base_module.util.JsonUtils
import com.ddzx.base_module.util.NetworkConnectivity
import com.squareup.moshi.Json
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


/**
 *远程数据提供者
 **/

class RemoteRepository @Inject
constructor(
    private val serviceGenerator: ServiceGenerator,
    private val networkConnectivity: NetworkConnectivity
) {
    /**
     * 获取日历信息
     */
    suspend fun getCalendarInfo(): Resource<ArrayList<CalendarData>> {
        val calendarInfo = serviceGenerator.createService(CalendarService::class.java)
        val resource = JsonUtils.processCall(networkConnectivity,calendarInfo::getCalendarInfo)
      return  when(resource){
          NO_INTERNET_CONNECTION -> Resource.error(msg = "无网络", status = NO_INTERNET_CONNECTION)
          NETWORK_ERROR -> Resource.error(msg = "网络异常", status = NETWORK_ERROR)
          is Int -> Resource.error(status = resource, msg = "请求异常")
          is Resource<*> -> JsonUtils.json2Data(resource as Resource<ArrayList<CalendarData>>)
          else ->Resource.error(msg = "未知异常", status = DEFAULT_ERROR)
        }
    }

    /**
     * 获取节日信息
     */
    suspend fun getFestivalInfo(): Resource<FestivalInfo> {
        val calendarInfo = serviceGenerator.createService(CalendarService::class.java)
        val resource = JsonUtils.processCall(networkConnectivity,calendarInfo::getFestivalInfo)
        return  when(resource){
            NO_INTERNET_CONNECTION -> Resource.error(msg = "无网络", status = NO_INTERNET_CONNECTION)
            NETWORK_ERROR -> Resource.error(msg = "网络异常", status = NETWORK_ERROR)
            is Int -> Resource.error(status = resource, msg = "请求异常")
            is Resource<*> -> JsonUtils.json2Data(resource as Resource<FestivalInfo>)
            else ->Resource.error(msg = "未知异常", status = DEFAULT_ERROR)
        }
        }

}
