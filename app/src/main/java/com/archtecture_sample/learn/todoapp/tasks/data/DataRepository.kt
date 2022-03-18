package com.archtecture_sample.learn.todoapp.tasks.data

import com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar.CalendarData
import com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar.FestivalInfo
import com.archtecture_sample.learn.todoapp.tasks.data.dto.login.LoginResponse
import com.ddzx.base_module.data.remote.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 *[整个module的数据源,包含远程数据+本地数据]
 **/
class DataRepository @Inject constructor(private val remoteRepository: RemoteRepository,private val localRepository: LocalRepository) : DataRepositorySource{

   override suspend fun getCalendarData(): Resource<ArrayList<CalendarData>> {
        return remoteRepository.getCalendarInfo()
    }

    override suspend fun getFestivalInfo(): Resource<FestivalInfo> {
        return remoteRepository.getFestivalInfo()
    }

    override fun getLocalAccount(): Resource<LoginResponse> {
        return localRepository.getLocalAccount()
    }
}