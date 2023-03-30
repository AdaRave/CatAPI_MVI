package com.example.mvi_catapi.presentation.screen.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mvi_catapi.domain.model.CategoriesModel
import com.example.mvi_catapi.presentation.items.CategoriesItem
import com.example.mvi_catapi.presentation.items.ErrorItem
import com.example.mvi_catapi.presentation.items.LoadItem

@Composable
fun MainScreen(navHostController: NavController) {

    val viewModel = hiltViewModel<MainViewModel>()

    val state by viewModel.state.collectAsState()

    when {
        state.isLoading -> {
            Log.d("checkData", "Loading...")
            LoadItem()
        }
        state.data.isNotEmpty() -> {
            Log.d("checkData", "data size: ${state.data.size}")
            MainScreenContent(state.data)
        }
        state.error != null -> {
            Log.d("checkData", "Error ${state.error}")
            ErrorItem(state.error) {
                viewModel.sendEvent(MainScreenEvent.LoadingData)
            }
        }
    }
}

@Composable
fun MainScreenContent(data: List<CategoriesModel>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn() {
            item {
                Text(
                    text = "Cat categories",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 10.dp, bottom = 10.dp)
                )
            }
            items(data) { cat ->
                CategoriesItem(cat, modifier = Modifier.padding(vertical = 16.dp, horizontal = 10.dp))

            }
        }
    }
}
