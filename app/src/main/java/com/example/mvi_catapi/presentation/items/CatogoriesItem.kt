package com.example.mvi_catapi.presentation.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvi_catapi.domain.model.CategoriesModel
import java.util.*


@Composable
fun CategoriesItem(cat: CategoriesModel, modifier: Modifier) {
    val color = Color(
        Random().nextInt(256),
        Random().nextInt(256),
        Random().nextInt(256),
        alpha = 30
    )

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(color)
                .padding(vertical = 16.dp, horizontal = 14.dp)
        ) {
            Column {
                Text(text = cat.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = cat.id.toString(),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 15.dp)
                )

            }
        }
    }

}