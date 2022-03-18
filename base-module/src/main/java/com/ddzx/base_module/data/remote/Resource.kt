package com.ddzx.base_module.data.remote

import com.ddzx.base_module.config.BaseConfig
import com.ddzx.base_module.data.error.API_OK

//sealed class Resource<T>(
//    val data: T? = null,
//    val errorCode: Int? = null
//) {
//    class Success<T>(data: T) : Resource<T>(data)
//    class Loading<T>(data: T? = null) : Resource<T>(data)
//    class DataError<T>(errorCode: Int = 0) : Resource<T>(null, errorCode)
//
//    override fun toString(): String {
//        return when (this) {
//            is Success<*> -> "Success[data=$data]"
//            is DataError -> "Error[exception=$errorCode]"
//            is Loading<T> -> "Loading"
//        }
//    }
//}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

data class Resource<out T>(val resultStatus: Status,val status: Int , val data: T?, val errMsg: String ) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(resultStatus = Status.SUCCESS, status = API_OK, data = data,errMsg = "ok")
        }

        fun <T> error(status : Int ,msg: String): Resource<T> {
            return Resource(resultStatus = Status.ERROR,status =  status,  data = null, errMsg =  msg)
        }

        fun <T> loading(): Resource<T> {
            return Resource(resultStatus = Status.LOADING, status = API_OK, data = null, errMsg = "loading")
        }
    }
}