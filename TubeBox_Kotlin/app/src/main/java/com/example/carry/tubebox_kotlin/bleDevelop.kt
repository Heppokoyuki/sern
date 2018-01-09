package com.example.carry.ble_develop

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context.BLUETOOTH_SERVICE
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.content.Context
import android.content.Context.BLUETOOTH_SERVICE
import android.content.Intent
import android.support.v4.content.PermissionChecker
import java.util.jar.Manifest


class ble : AppCompatActivity() {
    lateinit var bleManager : BluetoothManager
    lateinit var bleAdapter : BluetoothAdapter
    lateinit var bleScanner : BluetoothLeScanner

    val REQUEST_BLUETOOTH = 0
    val REQUEST_LOCATION_PERM = 1
    @SuppressLint("ServiceCast")

    fun First(savedInstanceState: Bundle?) {
        bleManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bleAdapter = bleManager.adapter
        checkLocationPerm()
        checkAdapterEnabled()
    }

    fun checkAdapterEnabled(){
        if (!bleAdapter.isEnabled){
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, REQUEST_BLUETOOTH)
        }
    }

    fun checkLocationPerm(){
        val perm = PermissionChecker.checkSelfPermission(applicationContext, android.Manifest.permission.ACCESS_FINE_LOCATION)
        if (perm == PermissionChecker.PERMISSION_GRANTED){

        }else requestLocationPerm()
    }

    fun requestLocationPerm(){
        requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),REQUEST_LOCATION_PERM)
    }
}
