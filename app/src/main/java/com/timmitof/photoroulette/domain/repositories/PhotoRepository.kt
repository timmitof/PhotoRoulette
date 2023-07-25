package com.timmitof.photoroulette.domain.repositories

import androidx.paging.PagingData
import com.timmitof.photoroulette.data.models.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {

    suspend fun getPagedPhotos(): Flow<PagingData<Photo>>
}