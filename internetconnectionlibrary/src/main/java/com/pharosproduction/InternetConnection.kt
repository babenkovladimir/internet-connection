package com.pharosproduction

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager

class InternetConnection(val application: Application) {

    private var networkReceiver = NetworkReceiver()


    fun registerReceiver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        application.registerReceiver(networkReceiver, intentFilter)

    }

    fun addConnectionListener(connectionListener: ConnectionListener) {
        NetworkReceiver.connectionListener = connectionListener
    }

    interface ConnectionListener {
        fun listenConnection(isConnected: Boolean)
    }
}


private class NetworkReceiver : BroadcastReceiver() {

    companion object {
        var connectionListener: InternetConnection.ConnectionListener? = null
    }

    // Life

    override fun onReceive(context: Context, intent: Intent) {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo

        //should check null because in airplane mode it will be null
        val isOnline = netInfo != null && netInfo.isConnected

        connectionListener?.let { it.listenConnection(isOnline) }
    }
}



