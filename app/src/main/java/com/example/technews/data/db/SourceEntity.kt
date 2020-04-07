package com.example.technews.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sources")
data class SourceEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "name")
    val name: String
)