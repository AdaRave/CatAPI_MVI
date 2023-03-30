package com.example.mvi_catapi.data

import com.example.mvi_catapi.domain.model.CategoriesModel
import retrofit2.http.GET

interface CatApi {
    @GET ("categories")
    suspend fun getCategories() : List<CategoriesModel>
}