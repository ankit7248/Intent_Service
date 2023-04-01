package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
           Intent(this@MainActivity, MyService::class.java).also {
               startService(it)
                tvServiceInfo.text = "Service running"

            }

        }

        btnStop.setOnClickListener {
            Intent(this@MainActivity, MyService::class.java).also {
                stopService(it)
                tvServiceInfo.text = "Service stopped"
            }

        }
        btnSend_Data.setOnClickListener {
           Intent(this@MainActivity, MyService::class.java).also {
                val dataString = Data_String.text.toString()
                it.putExtra("Extra_Data", dataString)
                startService(it)
            }
        }
    }
}