package com.archtecture_sample.learn.todoapp.tasks.data

import android.content.Context
import com.archtecture_sample.learn.todoapp.tasks.data.dto.login.LoginResponse
import com.ddzx.base_module.data.remote.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 *本地数据交互
 **/
class LocalRepository @Inject constructor(private val context: Context){

    fun getLocalAccount() : Resource<LoginResponse>{
        return   return Resource.success(LoginResponse("123", "Ahmed", "Mahmoud",
            "FrunkfurterAlle", "77", "12000", "Berlin",
            "Germany", "ahmed@ahmed.ahmed"))
    }
}