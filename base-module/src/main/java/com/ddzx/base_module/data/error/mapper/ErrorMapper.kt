package com.ddzx.base_module.data.error.mapper

import android.content.Context
import com.ddzx.base_module.R
import com.ddzx.base_module.data.error.*
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * 异常匹配信息放置此处
 */
class ErrorMapper @Inject constructor(@ApplicationContext val context: Context) :
    ErrorMapperSource {

    override fun getErrorString(errorId: Int): String {
        return context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(
            Pair(NO_INTERNET_CONNECTION, getErrorString(R.string.base_module_no_internet)),
            Pair(NETWORK_ERROR, getErrorString(R.string.base_module_network_error)),
            Pair(USER_NAME_ERROR, getErrorString(R.string.base_module_invalid_username)),
            Pair(PASS_WORD_ERROR, getErrorString(R.string.base_module_invalid_password)),
        ).withDefault { getErrorString(R.string.base_module_no_internet) }
}
