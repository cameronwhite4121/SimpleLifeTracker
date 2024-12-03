package com.example.simplelifetracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThreePlayerGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_three_player_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        gameStart()
    }
    private fun gameStart() {

        // Initialize buttons/textviews
        val winningPlayer: TextView = findViewById(R.id.winningPlayer)
        val resetButton: Button = findViewById(R.id.resetButton)
        val settingsButton: Button = findViewById(R.id.button_settings);

        // Subtract life buttons
        val player1Minus: Button = findViewById(R.id.player1minus)
        val player2Minus: Button = findViewById(R.id.player2minus)
        val player3Minus: Button = findViewById(R.id.player3minus)

        // Add life buttons
        val player1Plus: Button = findViewById(R.id.player1plus)
        val player2Plus: Button = findViewById(R.id.player2plus)
        val player3Plus: Button = findViewById(R.id.player3plus)

        // Life tracker textviews
        val player1LifeTextView: TextView = findViewById(R.id.player1life)
        val player2LifeTextView: TextView = findViewById(R.id.player2life)
        val player3LifeTextView: TextView = findViewById(R.id.player3life)

        // Set life totals
        var player1Life = 40
        player1LifeTextView.text = "$player1Life"
        var player2Life = 40
        player2LifeTextView.text = "$player2Life"
        var player3Life = 40
        player3LifeTextView.text = "$player3Life"

        settingsButton.setOnClickListener {

        }

        fun checkForWinner() {
            // Check for 3 losers, if so, there is a winner
            var numPlayerRip = 0
            if (player1Life == 0) {
                numPlayerRip++
            }
            if (player2Life == 0) {
                numPlayerRip++
            }
            if (player3Life == 0) {
                numPlayerRip++
            }

            // If there is a winner, display the winner
            if (numPlayerRip == 2) {
                if (player1Life != 0) {
                    winningPlayer.text = "Player 1 wins!"
                }
                if (player2Life != 0) {
                    winningPlayer.text = "Player 2 wins!"
                }
                if (player3Life != 0) {
                    winningPlayer.text = "Player 3 wins!"
                }
            }
            else {
                // Code is necessary to clear winningPlayer textview
                // if a player accidentally loses the game.
                winningPlayer.text = ""
            }
        }

        resetButton.setOnClickListener {
            player1Life = 40
            player1LifeTextView.text = "$player1Life"
            player2Life = 40
            player2LifeTextView.text = "$player2Life"
            player3Life = 40
            player3LifeTextView.text = "$player3Life"
            winningPlayer.text = ""
        }

        // Subtract life button listeners
        player1Minus.setOnClickListener {
            player1Life--
            if (player1Life <= 0) {
                player1Life = 0
                player1LifeTextView.text = "R.I.P"
                checkForWinner()
            }
            else {
                player1LifeTextView.text = "$player1Life"
            }
        }
        player2Minus.setOnClickListener {
            player2Life--
            if (player2Life <= 0) {
                player2Life = 0
                player2LifeTextView.text = "R.I.P"
                checkForWinner()
            }
            else {
                player2LifeTextView.text = "$player2Life"
            }
        }
        player3Minus.setOnClickListener {
            player3Life--
            if (player3Life <= 0) {
                player3Life = 0
                player3LifeTextView.text = "R.I.P"
                checkForWinner()
            }
            else {
                player3LifeTextView.text = "$player3Life"
            }
        }

        // Add life button listeners
        player1Plus.setOnClickListener {
            player1Life++
            player1LifeTextView.text = "$player1Life"
            // Call check for winner in case we need to clear the winning player textview
            checkForWinner()
        }
        player2Plus.setOnClickListener {
            player2Life++
            player2LifeTextView.text = "$player2Life"
            // Call check for winner in case we need to clear the winning player textview
            checkForWinner()
        }
        player3Plus.setOnClickListener {
            player3Life++
            player3LifeTextView.text = "$player3Life"
            // Call check for winner in case we need to clear the winning player textview
            checkForWinner()
        }
    }
}