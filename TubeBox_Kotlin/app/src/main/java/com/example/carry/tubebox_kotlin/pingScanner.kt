package com.example.carry.tubebox_kotlin

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * Created by carry on 2/10/2018.
 */

class pingScanner{
    val ip = "192.168.100."
    fun ScanIP(start : Int, End : Int){
        var i : Int = start

        while (i<=End){
            var host :String = ip + i
            var scannedName : String = ""
            try {
                val inetAddress: InetAddress = InetAddress.getByName(host)
                if (inetAddress.isReachable(1000)){
                    scannedName = inetAddress.hostName
                }
            } finally {

            }
            i++
        }
    }
}