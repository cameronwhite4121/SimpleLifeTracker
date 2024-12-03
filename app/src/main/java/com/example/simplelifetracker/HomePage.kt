package com.example.simplelifetracker

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fourPlayerNavBtn: AppCompatButton = findViewById(R.id.fourPlayerNavBtn)

        // Navigates to the 4-player game activity
        fourPlayerNavBtn.setOnClickListener {
            val intent = Intent(this, FourPlayerGame::class.java)
            startActivity(intent)
        }

        val threePlayerNavBtn: AppCompatButton = findViewById(R.id.threePlayerNavBtn)

        // Navigates to the 3-player game activity
        threePlayerNavBtn.setOnClickListener {
            val intent = Intent(this, ThreePlayerGame::class.java)
            startActivity(intent)
        }

        val twoPlayerNavBtn: AppCompatButton = findViewById(R.id.twoPlayerNavBtn)

        // Navigates to the 3-player game activity
        twoPlayerNavBtn.setOnClickListener {
            val intent = Intent(this, TwoPlayerGame::class.java)
            startActivity(intent)
        }
    }
}