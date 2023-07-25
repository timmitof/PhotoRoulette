package com.timmitof.photoroulette.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.timmitof.photoroulette.data.api.ImagesApi
import com.timmitof.photoroulette.data.models.Photo

class PhotosPagingSource(
    private val loader: ImagesApi,
    private val pageSize: Int
): PagingSource<Int, Photo>() {

    private companion object {
        const val START_PAGE = 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val pageCount = params.key ?: START_PAGE
        try {
            if (pageCount <= 0) {
                return LoadResult.Error(IllegalArgumentException("Page count should be greater than 0"))
            }

            val response = loader.getImages(
                page = pageCount,
                perPage = pageSize
            )
            return if (response.isSuccessful && response.body() != null) {
                val photos = response.body()?.photos ?: emptyList()
                val prevKey = if (pageCount == START_PAGE) null else pageCount - 1
                val nextKey = if (photos.isEmpty()) null else pageCount + 1

                LoadResult.Page(
                    data = photos,
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            } else {
                LoadResult.Error(IllegalStateException("Failed to load images"))
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1) ?:
            state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}