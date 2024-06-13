package com.example.codingexercise

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ItemViewModel: ViewModel() {
    var items = mutableStateOf<List<Item>>(emptyList())
        private set

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            try {
                val fetchedItems = RetrofitInstance.api.getItems()
                    .filter { !it.name.isNullOrBlank() }
                    .sortedWith(compareBy({ it.listId }, { it.name }))
                items.value = fetchedItems
            } catch (e: Exception) {
                print("Unable to fetch items: $e")
            }
        }
    }
}