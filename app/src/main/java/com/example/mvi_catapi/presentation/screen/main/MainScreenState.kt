package com.example.mvi_catapi.presentation.screen.main

import com.example.mvi_catapi.domain.model.CategoriesModel
import com.example.mvi_catapi.presentation.base.UIState
import javax.annotation.concurrent.Immutable

@Immutable
data class MainScreenState(
    val isLoading: Boolean,
    val data: List<CategoriesModel>,
    val error: String? = null
) : UIState {
    companion object {
        fun initial() = MainScreenState(isLoading = true, data = emptyList(), error = null)
    }
}
