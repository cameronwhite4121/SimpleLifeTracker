package com.example.simplelifetracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        gameStart()
    }
    private fun gameStart() {

        // Initialize buttons

        val resetButton: Button = findViewById(R.id.resetButton)

        // Subtract life buttons
        val player1Minus: Button = findViewById(R.id.player1minus)
        val player2Minus: Button = findViewById(R.id.player2minus)
        val player3Minus: Button = findViewById(R.id.player3minus)
        val player4Minus: Button = findViewById(R.id.player4minus)

        // Add life buttons
        val player1Plus: Button = findViewById(R.id.player1plus)
        val player2Plus: Button = findViewById(R.id.player2plus)
        val player3Plus: Button = findViewById(R.id.player3plus)
        val player4Plus: Button = findViewById(R.id.player4plus)

        // Life tracker textviews
        val player1LifeTextView: TextView = findViewById(R.id.player1life)
        val player2LifeTextView: TextView = findViewById(R.id.player2life)
        val player3LifeTextView: TextView = findViewById(R.id.player3life)
        val player4LifeTextView: TextView = findViewById(R.id.player4life)

        // Set life totals
        var player1Life = 40
        player1LifeTextView.text = player1Life.toString()
        var player2Life = 40
        player2LifeTextView.text = player1Life.toString()
        var player3Life = 40
        player3LifeTextView.text = player1Life.toString()
        var player4Life = 40
        player4LifeTextView.text = player1Life.toString()

        resetButton.setOnClickListener() {
            player1Life = 40
            player1LifeTextView.text = player1Life.toString()
            player2Life = 40
            player2LifeTextView.text = player2Life.toString()
            player3Life = 40
            player3LifeTextView.text = player3Life.toString()
            player4Life = 40
            player4LifeTextView.text = player4Life.toString()
        }

        // Subtract life button listeners
        player1Minus.setOnClickListener {
            player1Life--
            if (player1Life <= 0) {
                player1Life = 0
                player1LifeTextView.text = "R.I.P"
            }
            else {
                player1LifeTextView.text = player1Life.toString()
            }
        }
        player2Minus.setOnClickListener {
            player2Life--
            if (player2Life <= 0) {
                player2Life = 0
                player2LifeTextView.text = "R.I.P"
            }
            else {
                player2LifeTextView.text = player2Life.toString()
            }
        }
        player3Minus.setOnClickListener {
            player3Life--
            if (player3Life <= 0) {
                player3Life = 0
                player3LifeTextView.text = "R.I.P"
            }
            else {
                player3LifeTextView.text = player3Life.toString()
            }
        }
        player4Minus.setOnClickListener {
            player4Life--
            if (player4Life <= 0) {
                player4Life = 0
                player4LifeTextView.text = "R.I.P"
            }
            else {
                player4LifeTextView.text = player4Life.toString()
            }
        }

        // Add life button listeners
        player1Plus.setOnClickListener {
            player1Life++
            player1LifeTextView.text = player1Life.toString()
        }
        player2Plus.setOnClickListener {
            player2Life++
            player2LifeTextView.text = player2Life.toString()
        }
        player3Plus.setOnClickListener {
            player3Life++
            player3LifeTextView.text = player3Life.toString()
        }
        player4Plus.setOnClickListener {
            player4Life++
            player4LifeTextView.text = player4Life.toString()
        }
    }
}