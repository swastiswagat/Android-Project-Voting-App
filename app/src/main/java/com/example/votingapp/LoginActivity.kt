package com.example.votingapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Patterns

class LoginActivity : AppCompatActivity() {

    private lateinit var userEmail: EditText
    private lateinit var userPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var forgetPassword: TextView
    private lateinit var dontHaveAcc: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userEmail = findViewById(R.id.user_email)
        userPassword = findViewById(R.id.user_password)
        loginButton = findViewById(R.id.login_button)
        forgetPassword = findViewById(R.id.forget_password)
        dontHaveAcc = findViewById(R.id.donthaveacc)

        loginButton.setOnClickListener {
            val email = userEmail.text.toString()
            val password = userPassword.text.toString()

            if (validateInput(email, password)) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }
        }
        dontHaveAcc.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        forgetPassword.setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return when {
            email.isEmpty() -> {
                userEmail.error = "Email is required"
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                userEmail.error = "Enter a valid email address"
                false
            }
            password.isEmpty() -> {
                userPassword.error = "Password is required"
                false
            }
            password.length < 6 -> {
                userPassword.error = "Password should be at least 6 characters long"
                false
            }
            else -> true
        }
    }
}