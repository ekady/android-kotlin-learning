package com.example.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.inventory.data.Item
import com.example.inventory.data.ItemDao
import kotlinx.coroutines.launch

class InventoryViewModel(private val itemDao: ItemDao) : ViewModel() {

    private fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.insert(item)
        }
    }

    private fun getNewItemEntry(name: String, price: String, quantity: String): Item {
        return Item(
            itemName = name,
            itemPrice = price.toDouble(),
            quantityInStock = quantity.toInt()
        )
    }

    fun addNewitem(name: String, price: String, quantity: String) {
        val item = getNewItemEntry(name, price, quantity)
        insertItem(item)
    }

    fun isEntryValid(name: String, price: String, quantity: String): Boolean {
        if (name.isBlank() || price.isBlank() || quantity.isBlank()) return false
        return true
    }
}

class InventoryViewModelFactory(private val itemDao: ItemDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InventoryViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}