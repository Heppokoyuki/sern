package com.example.carry.tubebox_kotlin

import android.util.Log
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import android.graphics.Bitmap
import kotlin.concurrent.thread


/**
 * Created by carry on 2/10/2018.
 */

class pingScanner{
    val ip = "192.168.1."
    fun pingScan(start:Int, end:Int, startPort:Int, endPort:Int) {
        var i = start
        var e = startPort
        var ipcon : String
        while (i<=end){
            while (e<=endPort){
                ipcon = ip + i + ":" + e
                    Thread(Runnable { scan(ipcon) })
                e++
            }
            i++
        }
    }

    fun scan(ipcon:String){
            val netController : InetAddress = InetAddress.getByName(ipcon)
            if (netController.isReachable(500)) {
                val name :String = netController.hostName
                Log.i("name", name)
            }else {
                Log.i("result", "Unable to connect " + ipcon)
            }
    }
}
