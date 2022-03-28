package com.archtecture_sample.learn.todoapp.tasks.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.archtecture_sample.learn.todoapp.tasks.data.DataRepository
import com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar.CalendarData
import com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar.FestivalInfo
import com.ddzx.base_module.base.BaseViewModel
import com.ddzx.base_module.data.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
*@Describe ：[提供登录交互流程]
**/

@HiltViewModel
class LoginViewModel @Inject constructor (private val dataRepository: DataRepository): BaseViewModel(){

    private val calendarResponsePrivate  =  MutableLiveData<Resource<ArrayList<CalendarData>>>()
    val calendarResponseInfo : LiveData<Resource<ArrayList<CalendarData>>> get() = calendarResponsePrivate


    private val festivalInfoPrivate = MutableLiveData<Resource<FestivalInfo>>()
    val festivalInfo : LiveData<Resource<FestivalInfo>> get() = festivalInfoPrivate

    fun getCalendarInfo(){
        viewModelScope.launch {
            calendarResponsePrivate.value =  dataRepository.getCalendarData()
        }
    }

    fun getFestivalInfo(){
        viewModelScope.launch {
            festivalInfoPrivate.value = Resource.loading()
            festivalInfoPrivate.value =  dataRepository.getFestivalInfo()
        }
    }

}