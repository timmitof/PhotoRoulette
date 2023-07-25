package com.timmitof.photoroulette.data.dto

import com.google.gson.annotations.SerializedName

data class PaginationDto(
    @SerializedName("next_page")
    val nextPage: String,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("photos")
    val photos: List<PhotoDto>,
    @SerializedName("total_results")
    val totalResults: Int
)