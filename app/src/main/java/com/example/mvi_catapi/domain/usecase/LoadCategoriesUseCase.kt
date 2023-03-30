package com.example.mvi_catapi.domain.usecase

import com.example.mvi_catapi.data.DomainRepositoryImpl
import com.example.mvi_catapi.domain.model.CategoriesModel
import javax.inject.Inject

class LoadCategoriesUseCase @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
) : BaseUseCase<List<CategoriesModel>>() {
    override suspend fun invoke(): List<CategoriesModel> = domainRepository.getCategories()
}