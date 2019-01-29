package com.pharosproduction.internetconnection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pharosproduction.InternetConnection

class MainActivity : AppCompatActivity(), InternetConnection.ConnectionListener {

    // Life

    override fun listenConnection(isConnected: Boolean) {
        Log.d("TAGA", "isConnected $isConnected")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).internetConnection.addConnectionListener(this)
    }
}
