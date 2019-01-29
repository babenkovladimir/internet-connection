package com.pharosproduction.internetconnection

import android.app.Application
import com.pharosproduction.InternetConnection

class App : Application() {

    lateinit var internetConnection: InternetConnection

    override fun onCreate() {
        super.onCreate()
        internetConnection = InternetConnection(this)
        internetConnection.registerReceiver()
    }

}