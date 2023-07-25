package com.timmitof.photoroulette.domain.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.timmitof.photoroulette.data.api.ImagesApi
import com.timmitof.photoroulette.data.models.Photo
import com.timmitof.photoroulette.domain.paging.PhotosPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val imagesApi: ImagesApi
): PhotoRepository {

    private companion object {
        const val PAGE_SIZE = 15
    }

    override suspend fun getPagedPhotos(): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = true,
                initialLoadSize = PAGE_SIZE
            ),
            pagingSourceFactory = { PhotosPagingSource(imagesApi, PAGE_SIZE) }
        ).flow
    }
}