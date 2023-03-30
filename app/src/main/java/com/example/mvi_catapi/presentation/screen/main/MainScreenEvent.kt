package com.example.mvi_catapi.presentation.screen.main

import com.example.mvi_catapi.domain.model.CategoriesModel
import com.example.mvi_catapi.presentation.base.UIEvent
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenEvent : UIEvent {
    object LoadingData : MainScreenEvent()

    data class ShowData(val data: List<CategoriesModel>) : MainScreenEvent()
    data class ShowError(val errorMessage: String) : MainScreenEvent()

}