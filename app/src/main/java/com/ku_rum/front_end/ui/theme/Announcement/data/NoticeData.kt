package com.ku_rum.front_end.ui.theme.Announcement.data

import java.sql.Date

data class NoticeData(
    val type: String,
    val title: String,
    val date: String,
    val important: Int,
    val bookmark: Int
)
