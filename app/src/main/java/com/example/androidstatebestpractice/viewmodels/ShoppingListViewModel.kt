package com.example.androidstatebestpractice.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShoppingListViewModel : ViewModel() {
    private val _shoppingList = MutableStateFlow<List<String>>(emptyList())
    val shoppingList: StateFlow<List<String>> = _shoppingList

    fun addItem(item: String) {
        viewModelScope.launch {
            _shoppingList.value = _shoppingList.value + item
        }
    }

    fun removeItem(item: String) {
        viewModelScope.launch {
            _shoppingList.value = _shoppingList.value.filter { it != item }
        }
    }
}