package com.timmitof.photoroulette.data.dto

import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("alt")
    val alt: String,
    @SerializedName("avg_color")
    val avgColor: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("liked")
    val liked: Boolean,
    @SerializedName("photographer")
    val photographer: String,
    @SerializedName("photographer_id")
    val photographerId: Int,
    @SerializedName("photographer_url")
    val photographerUrl: String,
    @SerializedName("src")
    val src: SrcDto,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)