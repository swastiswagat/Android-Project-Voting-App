package com.example.votingapp  // Match your package

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
<<<<<<< HEAD
import com.example.votingapp.R
=======
import com.example.votingapp.Activity.LoginActivity
>>>>>>> f1354ea42783eb12b821af1ceedf765576ba5378

class SplashActivity : AppCompatActivity() {

    private lateinit var lottieAnimationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lottieAnimationView = findViewById(R.id.lottieAnimationView)


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
<<<<<<< HEAD
        }, 3010)
=======
        }, 3005)
>>>>>>> f1354ea42783eb12b821af1ceedf765576ba5378
    }
}
