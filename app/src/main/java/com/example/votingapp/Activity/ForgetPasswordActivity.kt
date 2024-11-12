package com.example.votingapp.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.votingapp.R

class ForgetPasswordActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        val emailInput = findViewById<EditText>(R.id.user_email)
        val submitButton = findViewById<Button>(R.id.login_button)

        submitButton.setOnClickListener {
            val email = emailInput.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Password reset link sent to $email", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
