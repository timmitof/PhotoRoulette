package com.timmitof.photoroulette.data.mapper

import com.timmitof.photoroulette.data.dto.*
import com.timmitof.photoroulette.domain.models.*

internal fun PaginationDto.toDomain(): Pagination {
    return Pagination(
        nextPage = nextPage,
        page = page,
        perPage = perPage,
        photos = photos.map { it.toDomain() },
        totalResults = totalResults
    )
}

internal fun PhotoDto.toDomain(): Photo {
    return Photo(
        alt = alt,
        avgColor = avgColor,
        height = height,
        id = id,
        liked = liked,
        photographer = photographer,
        photographerId = photographerId,
        photographerUrl = photographerUrl,
        src = src.toDomain(),
        url = url,
        width = width
    )
}

internal fun SrcDto.toDomain(): Src {
    return Src(
        landscape = landscape,
        large = large,
        large2x = large2x,
        medium = medium,
        original = original,
        portrait = portrait,
        small = small,
        tiny = tiny
    )
}