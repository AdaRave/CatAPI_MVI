package com.example.mvi_catapi.domain.repository

import com.example.mvi_catapi.domain.model.CategoriesModel

interface DomainRepository {
    suspend fun getCategories() : List<CategoriesModel>
}