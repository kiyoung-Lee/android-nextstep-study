package com.example.luke.serviceclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.R.attr.button
import android.content.Context.BIND_AUTO_CREATE
import android.content.Intent
import android.content.ComponentName
import android.content.Context
import android.os.IBinder
import android.content.ServiceConnection
import android.os.RemoteException
import android.view.View
import android.widget.TextView
import com.example.luke.myapplication.IRemoteService


class MainActivity : AppCompatActivity() {

    private val SERVER_PACKAGE = "com.example.luke.myapplication"

    private val SERVER_ACTION = "com.example.luke.action.myapplication"

    private var mRemoteService: IRemoteService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceIntent = Intent(SERVER_ACTION)
        serviceIntent.setPackage(SERVER_PACKAGE)
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE)

        val button = findViewById(R.id.main_text_view) as TextView
        button.setOnClickListener {
            try {
                val sum = mRemoteService?.sum(2, 5)
                Toast.makeText(applicationContext, sum.toString(), Toast.LENGTH_SHORT).show()
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(serviceConnection)
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            mRemoteService = IRemoteService.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mRemoteService = null
        }
    }

}
