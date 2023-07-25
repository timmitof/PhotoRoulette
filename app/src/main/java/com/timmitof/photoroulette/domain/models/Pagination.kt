package com.timmitof.photoroulette.domain.models

data class Pagination(
    val nextPage: String?,
    val page: Int?,
    val perPage: Int?,
    val photos: List<Photo>?,
    val totalResults: Int?
)