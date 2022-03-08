package com.example.appnote.model

import org.threeten.bp.LocalDateTime
import java.util.*

data class Note(
    val id: UUID = UUID.randomUUID(), //se creara un random ID por cada nota en este caso
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
