package com.example.codingexercise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ItemListScreen(viewModel: ItemViewModel = viewModel(), modifier: Modifier = Modifier) {
    val items by viewModel.items

    val groupedItems = remember(items) {
        items.groupBy { it.listId }
    }

    LazyColumn(modifier = modifier) {
        groupedItems.forEach { (listId, items) ->
            item {
                Text(
                    text = "List ID: $listId",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(16.dp)
                )
            }
            items(items) { item ->
                ListItem(item = item)
                Divider(color = Color.Gray, thickness = 1.dp)
            }
        }
    }
}