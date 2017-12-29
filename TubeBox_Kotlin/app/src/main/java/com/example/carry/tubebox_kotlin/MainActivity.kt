package com.example.carry.tubebox_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val callKuSocket = KuSocket()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {Connect()}
        button2.setOnClickListener {callKuSocket.sendMessage(editText3.text.toString())}
    }
    fun Connect(){
        val ip = editText.text.toString()
        val po = editText2.text.toString()
        callKuSocket.connectWebSocket(ip, po)
    }
    fun sendTextToBox(message : String){
        textView.text = message
    }
    fun connectionOpened(){
        textView.text = "Connection Opened"
    }
}
