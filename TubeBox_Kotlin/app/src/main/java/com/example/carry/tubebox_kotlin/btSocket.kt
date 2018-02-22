package com.example.carry.tubebox_kotlin

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.util.Log
import java.util.*


/**
 * Created by carry on 2/22/2018.
 */
class btSocket {
    val adpt : BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    val uuid : UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    fun searchBtDevice(name : String){
        var devices = adpt.bondedDevices
        var searchName : String = name
        var deviceArray : Array<BluetoothDevice>
        var device : BluetoothDevice
        if (devices != null){
            deviceArray = devices.toTypedArray()
            var i : Int = 0
            while(i < deviceArray.size){
                        var deviceName = deviceArray[i].name
                        Log.i("foundDevice", deviceName)
//                        if (deviceName == searchName){
//                            device = deviceArray[i]
//                            connectBtDevice(device)
//                            break
//                }
                i++
            }
        }
    }

//    fun connectBtDevice(device: BluetoothDevice){
//        val socket : BluetoothSocket = device.createRfcommSocketToServiceRecord(uuid)
//        socket.connect()
//        socket.outputStream.write("Connected".toByteArray(UTF_8))
//
//    }

}