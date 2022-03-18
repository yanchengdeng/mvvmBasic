package com.archtecture_sample.learn.todoapp.tasks.data

import com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar.CalendarData
import com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar.FestivalInfo
import com.ddzx.base_module.data.remote.Resource
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 *@Author : yancheng
 *@Date : 2022/3/17
 *@Time : 9:47
 *@Describe ：
 **/
interface CalendarService {

    @GET("calendar/nextdetail?token=74F1BE7757B9B72E0D531AA4199437DF&timestamp=1462377600&client=ceshi")
    suspend fun getCalendarInfo() : Response<Resource<ArrayList<CalendarData>>>


    @GET("Calendar/FestivalInfo?name=%E8%BE%9B%E4%BA%A5%E9%9D%A9%E5%91%BD%E7%BA%AA%E5%BF%B5%E6%97%A5&client=ceshi&simplified=0&token=A79D963960F24B84424723A2258BD703")
    suspend fun getFestivalInfo() : Response<Resource<FestivalInfo>>
}