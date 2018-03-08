package com.example.carry.tubebox_kotlin

import android.util.Log
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import java.net.URISyntaxException
object KuSocket {
    lateinit var mWebSocketClient: WebSocketClient
    fun connectWebSocket(ip :String, po :String) {
        val uri: URI
        try {
            uri = URI("ws:/$ip:$po")
        } catch (e: URISyntaxException) {
            e.printStackTrace()
            return
        }
        mWebSocketClient = object : WebSocketClient(uri) {
            override fun onOpen(serverHandshake: ServerHandshake) {
                Log.i("Websocket", "Opened")
                mWebSocketClient.send("HelloWSWorld!")
                MainActivity.connected()
                UDPClient().connect(true)
            }

            override fun onMessage(s: String) {
                MainActivity.sendTextToBox(s)
                Log.i("message", s)
            }

            override fun onClose(i: Int, s: String, b: Boolean) {
                Log.i("Websocket", "Closed " + s)
                MainActivity.disconnected()
            }

            override fun onError(e: Exception) {
                Log.i("Websocket", "Error " + e.message)
            }
        }
        mWebSocketClient.connect()
    }

}

