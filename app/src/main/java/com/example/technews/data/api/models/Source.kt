package com.example.technews.data.api.models


import com.example.technews.data.db.SourceEntity
import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = ""
)

fun Source.toSourceEntity(): SourceEntity =
    SourceEntity(
        id = id,
        name = name
    )