package com.example.technews.data.db

import androidx.room.ColumnInfo

data class SourceEntity(
    @ColumnInfo(name = "source_id")
    val id: String?,
    @ColumnInfo(name = "source_name")
    val name: String?
)