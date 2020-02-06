package com.augustg.databindingrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScanViewModel : ViewModel() {

    var address = 10000
    var rssi = 99

    val scanResults: LiveData<MutableList<BluetoothScanResult>>
        get() = _scanResults

    private val _scanResults by lazy {
        MutableLiveData<MutableList<BluetoothScanResult>>(mutableListOf())
    }

    fun addScanResult() {
        val newList = scanResults.value
        newList?.add(BluetoothScanResult(address++.toString(), rssi--))
        _scanResults.value = newList
    }

    fun incrementScanResult(position: Int) {
        val newList = scanResults.value
        val previousScanResult = newList?.let { it[position] }
        previousScanResult?.let {
            newList.set(position, BluetoothScanResult((it.address.toInt() + 1).toString(), it.rssi - 1))
        }
        _scanResults.value = newList
    }

    fun clearScanResults() {
        _scanResults.value = mutableListOf()
    }

}