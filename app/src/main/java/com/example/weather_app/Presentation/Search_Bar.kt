package com.example.weather_app.Presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.colors
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search_Bar(
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    backgroundColor: Color,
    modifier: Modifier = Modifier

) {
    TextField(value = searchQuery, onValueChange = onQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 35.dp, start = 20.dp, end = 20.dp)
            .clip(MaterialTheme.shapes.extraLarge)
            .indicatorLine(
                enabled = false,
                isError = false,
                interactionSource = remember {
                    MutableInteractionSource()
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = backgroundColor,
                    focusedContainerColor = backgroundColor
                ),
                focusedIndicatorLineThickness = 0.dp,
                unfocusedIndicatorLineThickness = 0.dp,

            ),
        placeholder = { Text(text = "Search") }

    )
}