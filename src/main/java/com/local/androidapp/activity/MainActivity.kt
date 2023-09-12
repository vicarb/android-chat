package com.local.androidapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import com.local.androidapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // make sure this line is before findViewById

        val navigateToLoginButton: Button? = findViewById(R.id.navigateToLoginButton)  // make sure the ID matches

        navigateToLoginButton?.setOnClickListener {  // using safe call ?. to ensure it's not null
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
