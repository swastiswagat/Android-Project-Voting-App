package com.example.votingapp.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.votingapp.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var userEmail: EditText
    private lateinit var userAdharNo: EditText
    private lateinit var userPassword: EditText
    private lateinit var signUpButton: Button
    private lateinit var forgetPassword: TextView
    private lateinit var alreadyHaveAccount: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        userName = findViewById(R.id.user_name)
        userEmail = findViewById(R.id.user_email)
        userAdharNo = findViewById(R.id.user_adharno)
        userPassword = findViewById(R.id.user_password)
        signUpButton = findViewById(R.id.login_button)
        forgetPassword = findViewById(R.id.forget_password)
        alreadyHaveAccount = findViewById(R.id.dont_have_acc)

        signUpButton.setOnClickListener {
            val name = userName.text.toString()
            val email = userEmail.text.toString()
            val adharNo = userAdharNo.text.toString()
            val password = userPassword.text.toString()

            if (validateInput(name, email, adharNo, password)) {
                // Firebase or any other sign-up logic here
                Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()
            }
        }

        alreadyHaveAccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        forgetPassword.setOnClickListener {
            Toast.makeText(this, "Navigate to password recovery", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInput(name: String, email: String, adharNo: String, password: String): Boolean {
        return when {
            name.isEmpty() -> {
                userName.error = "Name is required"
                false
            }
            email.isEmpty() -> {
                userEmail.error = "Email is required"
                false
            }
            adharNo.isEmpty() -> {
                userAdharNo.error = "Adhar Number is required"
                false
            }
            password.isEmpty() -> {
                userPassword.error = "Password is required"
                false
            }
            else -> true
        }
    }
}
