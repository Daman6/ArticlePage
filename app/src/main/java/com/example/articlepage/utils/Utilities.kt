package com.example.myapplication.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.articlepage.R

object Utilities {

    private const val backColorString = "#071331"
    val backColor = Color(backColorString.toColorInt())

    private const val iconBackColorString = "#2B426E"
    val iconBackColor = Color(iconBackColorString.toColorInt())

    private const val defColor = "#0D2148"
    val innerColor = Color(defColor.toColorInt())

    private const val inactiveColorStr = "#808080"
    val inactiveColor = Color(inactiveColorStr.toColorInt())

    val activeColor = Color.White

    val cornerRadius = 7.dp
    val borderStroke = Color.White

    val opensansbold  = FontFamily(Font(R.font.opensansbold))
    val opensansregular  = FontFamily(Font(R.font.opensans_regular))
    val opensansitalic  = FontFamily(Font(R.font.opensans_italic))

}