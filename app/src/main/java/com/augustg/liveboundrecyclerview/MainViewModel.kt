package com.augustg.liveboundrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // observed by recycler view data binding expressions
    val listItems: LiveData<MutableList<String>>
        get() = _listItems

    private val _listItems by lazy {
        MutableLiveData<MutableList<String>>(mutableListOf())
    }

    // sample data
    private var itemValue = 10000

    /**
     * Adds an item to the list by increasing the sample data's value
     */
    fun addItem() {
        val newList = _listItems.value
        newList?.add(itemValue++.toString())
        _listItems.value = newList
    }

    /**
     * Increments an item's value in the list
     * Called when a list item is clicked to demonstrate the live UI
     */
    fun incrementItem(position: Int) {
        val newList = _listItems.value
        val previousItemValue = newList?.let { it[position] }
        previousItemValue?.let {
            newList.set(position, (it.toInt() + 1).toString())
        }
        _listItems.value = newList
    }

    /**
     * Clears the list of items
     */
    fun clearList() {
        _listItems.value = mutableListOf()
    }
}