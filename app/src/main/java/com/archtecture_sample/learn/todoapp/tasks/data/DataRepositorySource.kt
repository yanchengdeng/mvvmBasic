package com.archtecture_sample.learn.todoapp.tasks.data

import com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar.CalendarData
import com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar.FestivalInfo
import com.archtecture_sample.learn.todoapp.tasks.data.dto.login.LoginResponse
import com.ddzx.base_module.data.remote.Resource
import kotlinx.coroutines.flow.Flow

/***
 * 所有数据接口
 */
interface DataRepositorySource {
     suspend fun getCalendarData(): Resource< ArrayList<CalendarData>>
     suspend fun getFestivalInfo(): Resource<FestivalInfo>
     fun getLocalAccount() : Resource<LoginResponse>
}