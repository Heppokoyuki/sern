package com.example.carry.tubebox_kotlin

import android.util.Log
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import java.net.URISyntaxException

class KuSocket {
    lateinit var mWebSocketClient: WebSocketClient
    fun connectWebSocket(ip :String, po :String) {
        val uri: URI
        val ipAddress: String
        val port: String
        val callMain = MainActivity()
        try {
            ipAddress = ip
            port = po
            uri = URI("ws://$ipAddress:$port")
        } catch (e: URISyntaxException) {
            e.printStackTrace()
            return
        }
        mWebSocketClient = object : WebSocketClient(uri) {
            override fun onOpen(serverHandshake: ServerHandshake) {
                Log.i("Websocket", "Opened")
                mWebSocketClient.send("HelloWSWorld!")
                callMain.connectionOpened()
            }

            override fun onMessage(s: String) {
                callMain.sendTextToBox(s)
            }

            override fun onClose(i: Int, s: String, b: Boolean) {
                Log.i("Websocket", "Closed " + s)
            }

            override fun onError(e: Exception) {
                Log.i("Websocket", "Error " + e.message)
            }
        }
        mWebSocketClient.connect()
    }

}
