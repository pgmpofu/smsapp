package com.ai.smsapp

import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val sendButton = findViewById<Button>(R.id.sendButton)
    val destNumber = findViewById<TextInputEditText>(R.id.destNumber)

        sendButton.setOnClickListener{
            when (PackageManager.PERMISSION_GRANTED) {
                checkCallingOrSelfPermission(android.Manifest.permission.SEND_SMS) -> {
                    var smsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(destNumber.text.toString(), null, "Test from app", null, null)
                    Toast.makeText(applicationContext, "SMS SENDDDDDD", Toast.LENGTH_LONG);
                }
            }
        }
    }

}