package com.example.carry.tubebox_kotlin

import android.util.Log
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.util.*
import java.util.logging.Handler

/**
 * Created by carry on 3/3/2018.
 */
class UDPClient{
    //val Kusocket = KuSocket()
    lateinit var clientSocket : DatagramSocket
    lateinit var sendPacket : DatagramPa
    lateinit var receivePacket: DatagramPacket
    var IsConnected : Boolean = false
    var ip : InetAddress = InetAddress.getByName("255.255.255.255")
    var sendData : ByteArray =  "FindTubeBox".toByteArray()
    var receiveData : ByteArray = ByteArray(4096)
    var sendIp : String = ""
    fun findTube(){
//        while (sendIp == ""){
        Thread {
            clientSocket = DatagramSocket()
            sendPacket = DatagramPacket(sendData, sendData.size, ip, 9887)
            clientSocket.send(sendPacket)
            Log.i("UDP", "Sended")
        }.start()
        Thread{
            clientSocket = DatagramSocket()
            receivePacket = DatagramPacket(receiveData, receiveData.size)
            clientSocket.receive(receivePacket)
            sendIp =receivePacket.address.toString()
            Log.i("UDP", receivePacket.address.toString())
            clientSocket.close()
            KuSocket.connectWebSocket(sendIp, "9999")
        }.start()
//        }

    }
    fun connect(e : Boolean){
        IsConnected = e
    }
    fun toConnect(){
        Thread {
            var timeout: Int = 5
            while (IsConnected == false && timeout >= 0) {
                findTube()
                Thread.sleep(1000)
                timeout--
            }
            if (IsConnected == false) {
                MainActivity.sendTextToBox("Failed to connect")
            }
        }.start()
    }
}