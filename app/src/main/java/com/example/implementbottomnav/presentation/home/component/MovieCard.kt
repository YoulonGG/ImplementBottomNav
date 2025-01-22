package com.example.implementbottomnav.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.implementbottomnav.R
import com.example.implementbottomnav.core.components.LabelAndValue
import com.example.implementbottomnav.data.dto.response.Result

@Composable
fun MovieCard(
    detail: Result,
    tallestCardHeight: Dp,
    onCardHeightMeasured: (Dp) -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }
    val density = LocalDensity.current
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFd6ccc2),
        ),
        modifier = Modifier
            .padding(vertical = 5.dp)
            .onGloballyPositioned { layoutCoordinates ->
                val cardHeight = with(density) {
                    layoutCoordinates.size.height.toDp()
                }
                onCardHeightMeasured(cardHeight)
            }
            .heightIn(min = tallestCardHeight),
        onClick = {
            isExpanded = !isExpanded
        }
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            val imageUrl = "https://image.tmdb.org/t/p/w500${detail.posterPath}"
            AsyncImage(
                model = imageUrl,
                contentDescription = detail.title,
                placeholder = painterResource(id = R.drawable.placeholderimage),
                error = painterResource(id = R.drawable.placeholderimage),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(5.dp))
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = detail.title ?: "",
                color = Color.Black,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(5.dp))
            LabelAndValue(
                label = "Release Date: ",
                value = detail.releaseDate ?: ""
            )
            Spacer(modifier = Modifier.height(5.dp))
            if (isExpanded) {
                Text(
                    text = detail.overview ?: "",
                    maxLines = 10,
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                    color = Color.Black
                )
            }
        }
    }
}