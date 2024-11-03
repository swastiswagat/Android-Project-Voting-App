package com.example.votingapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var userEmail: EditText
    private lateinit var userPassword: EditText
    private lateinit var signupButton: Button
    private lateinit var alreadyHaveAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Initialize UI components
        userName = findViewById(R.id.user_name)
        userEmail = findViewById(R.id.user_email)
        userPassword = findViewById(R.id.user_password)
        signupButton = findViewById(R.id.signup_button)
        alreadyHaveAccount = findViewById(R.id.dont_have_acc)

        // Set up listener for the Sign-Up button
        signupButton.setOnClickListener {
            val name = userName.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (validateInput(name, email, password)) {
                // Perform signup logic (e.g., save to database, Firebase, etc.)
                Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()

                // After successful signup, navigate to the login page
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        // Set up listener for "Already have an account? Login" text
        alreadyHaveAccount.setOnClickListener {
            // Navigate to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Input validation function
    private fun validateInput(name: String, email: String, password: String): Boolean {
        return when {
            name.isEmpty() -> {
                userName.error = "Name is required"
                false
            }
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
