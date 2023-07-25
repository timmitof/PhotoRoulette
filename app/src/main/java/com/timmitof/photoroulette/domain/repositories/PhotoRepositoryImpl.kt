package com.timmitof.photoroulette.domain.repositories

import com.timmitof.photoroulette.data.api.ImagesApi
import com.timmitof.photoroulette.domain.models.Pagination
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val imagesApi: ImagesApi
): PhotoRepository {

}