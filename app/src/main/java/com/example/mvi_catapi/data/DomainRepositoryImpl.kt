package com.example.mvi_catapi.data

import com.example.mvi_catapi.domain.model.CategoriesModel
import com.example.mvi_catapi.domain.repository.DomainRepository
import javax.inject.Inject

class DomainRepositoryImpl @Inject constructor(
    private val api: CatApi
) : DomainRepository {

    override suspend fun getCategories(): List<CategoriesModel> {

        return api.getCategories()
    }
}