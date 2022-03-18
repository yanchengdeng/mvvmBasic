package com.archtecture_sample.learn.todoapp.tasks.data.dto.calendar


data class CalendarData(
    val ExplainListP: List<ExplainP>,
    val branchHourInfo: String,
    val constellation: String,
    val cs: String,
    val cxfgod: String,
    val datekey: String,
    val erba: String,
    val festivals: String,
    val isrun: Int,
    val ji: String,
    val jsyq: String,
    val lunar: String,
    val pzbj: String,
    val shenershen: String,
    val shichengjixiong: String,
    val taishen: String,
    val termBeginTime: String,
    val terms: String,
    val tgdz: String,
    val url: String,
    val vacationStatus: String,
    val weekDay: String,
    val weeks: String,
    val wx: String,
    val xsyj: String,
    val yi: String,
    val zs: String
)

data class ExplainP(
    val Explain: String,
    val ExplainListGroup: List<ExplainGroup>,
    val Title: String
)

data class ExplainGroup(
    val ExplainListC: List<ExplainC>,
    val GroupName: String
)

data class ExplainC(
    val Explain: String,
    val Title: String
)

data class FestivalInfo(
    val BizTitle: String,
    val Descption: String,
)

