package com.example.implementbottomnav.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun LabelAndValue(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    fontWeight: FontWeight = FontWeight.W500,
    color: Color = Color.Black,
    fontSize: TextUnit = 10.sp,
    lineHeight: TextUnit = 12.sp,
    textAlign: TextAlign = TextAlign.Start
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Text(
            text = label,
            fontWeight = fontWeight,
            color = color,
            fontSize = fontSize,
            lineHeight = lineHeight,
            textAlign = textAlign
        )
        Text(
            text = value,
            fontWeight = fontWeight,
            color = color,
            fontSize = fontSize,
            lineHeight = lineHeight,
            textAlign = textAlign
        )
    }
}
