package com.example.composeuiexample.ui.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun getGradient(startColor: Color,
                endColor: Color):Brush{

    return Brush.horizontalGradient(colors = listOf(startColor,endColor))
}