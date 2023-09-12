package com.local.androidapp.activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import com.local.androidapp.activity.MainActivity
import com.local.androidapp.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            // Get the username and password from the text fields.
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if the username and password are valid.
            if (username == "admin" && password == "1234") {
                // Navigate to the main activity.
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                // Show an error message.
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        val registerButton = findViewById<Button>(R.id.gotoRegisterButton)
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}