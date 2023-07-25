package com.timmitof.photoroulette.data.api

import com.timmitof.photoroulette.data.models.Pagination
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {

    @GET("v1/curated")
    suspend fun getImages(
        @Query("page") page: Int? = null,
        @Query("per_page") perPage: Int? = null
    ): Response<Pagination>
}