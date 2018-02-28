package com.example.carry.tubebox_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val KuSocket = KuSocket()
    val ip : String = "192.168.1.119"
    val po : String = "9999"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {Connect()}
        button2.setOnClickListener {KuSocket.mWebSocketClient.send("v_Up")}
        button3.setOnClickListener {KuSocket.mWebSocketClient.send("v_Down")}
    }
    fun Connect(){
        KuSocket.connectWebSocket(ip, po)
    }
    fun sendTextToBox(message : String){
        textView.text = message
    }
    fun connectionOpened(){
        textView.text = "Connection Opened"
    }
}
