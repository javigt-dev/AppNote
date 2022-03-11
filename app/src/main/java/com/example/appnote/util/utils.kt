package com.example.appnote.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Long): String{
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d MMM hh:mm aa", Locale.getDefault())
    return format.format(date)
}