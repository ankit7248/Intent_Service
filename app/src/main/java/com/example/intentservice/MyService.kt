package com.example.intentservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

class MyService: Service() {
    val TAG = "MyService"

    init {
        Log.d(TAG,"Service is running....")
    }

    override fun onBind(p0: Intent?): IBinder? = null // when In service have mutiple clients then we use this onBind

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("Extra_Data")
        dataString?.let {
            Log.d(TAG, dataString)
        }
//        thread {
//            while (true){       while loop -> goes infinite times in Main thread that's why I use Thread to execute in other thread
//
//            }
//        }

        return START_STICKY
    }


//    START_STICKY-> tells the system to create a fresh copy of the service,
//                  when sufficient memory is available, after it recovers from low memory.
//                  Here you will lose the results that might have computed before.

//    START_NOT_STICKY- tells the system not
//                      to bother to restart the service, even when it has sufficient memory.

//    START_REDELIVER_INTENT- tells the system to restart the service after the crash and also
//                            redeliver the intents that were present at the time of crash.
}