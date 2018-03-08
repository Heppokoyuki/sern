package com.example.carry.tubebox_kotlin

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.carry.tubebox_kotlin.R.id.textView
import com.marcinmoskala.arcseekbar.ArcSeekBar
import com.marcinmoskala.arcseekbar.ProgressListener
import kotlinx.android.synthetic.main.activity_main.*
import java.net.InetAddress

class MainActivity : Activity() {
    val UDP = UDPClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {callUDP()}
        button4.setOnClickListener {KuSocket.mWebSocketClient.send("pi_Restart")}
        volumeBar.onProgressChangedListener = ProgressListener {setVolume()}
        textview2 = findViewById<TextView>(R.id.textView)
        button_4 = findViewById<Button>(R.id.button4)
        Bar = findViewById<ArcSeekBar>(R.id.volumeBar)
        button_4?.isEnabled = false
        Bar?.isEnabled = false
    }
    companion object {
        var textview2:TextView? = null
        var button_4:Button? = null
        var Bar:ArcSeekBar? = null
        fun sendTextToBox(message : String){
            textview2?.text = message
        }
        fun connected(){
            button_4?.isEnabled = true
            Bar?.isEnabled = true
        }
        fun disconnected(){
            button_4?.isEnabled = false
            Bar?.isEnabled = false
        }
    }
    fun callUDP() {
        UDP.toConnect()
        textview2?.text = "Connecting..."
    }
    fun setVolume(){
        var value : Int = volumeBar.progress
//        KuSocket.mWebSocketClient.send("v_Set-" + value.toString() + "%")
        Volumetext.text = value.toString()
    }
}
