package org.pogchamp.lolchampions.presentation.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import org.pogchamp.lolchampions.databinding.SplashScreenBinding

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private lateinit var binding : SplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScreen,MainActivity::class.java)
           startActivity(intent)
            finish()
        }, 2000)
    }
}

