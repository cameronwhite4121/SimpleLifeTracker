package com.example.simplelifetracker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TwoPlayerGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_two_player_game)
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
        val settingsButton: Button = findViewById(R.id.settingsButton)
        val closeOverlayButton: Button = findViewById(R.id.closeOverlayButton)
        val homeButton: Button = findViewById(R.id.homeButton)

        // Subtract life buttons
        val player1Minus: Button = findViewById(R.id.player1minus)
        val player2Minus: Button = findViewById(R.id.player2minus)

        // Add life buttons
        val player1Plus: Button = findViewById(R.id.player1plus)
        val player2Plus: Button = findViewById(R.id.player2plus)

        // Life tracker textviews
        val player1LifeTextView: TextView = findViewById(R.id.player1life)
        val player2LifeTextView: TextView = findViewById(R.id.player2life)

        // Initialize hidden overlay
        val overlayContainer: View = findViewById(R.id.overlayContainer)

        // Set life totals
        var player1Life = 40
        player1LifeTextView.text = "$player1Life"
        var player2Life = 40
        player2LifeTextView.text = "$player2Life"

        fun checkForWinner() {
            // If there is a loser, display the winner
            if (player1Life == 0) {
                winningPlayer.text = "Player 2 wins!"
            }
            else if (player2Life == 0) {
                winningPlayer.text = "Player 1 wins!"
            }
            else {
                // Code is necessary to clear winningPlayer textview
                // if a player accidentally loses the game.
                winningPlayer.text = ""
            }
        }

        fun openOverlay() {
            overlayContainer.setVisibility(View.VISIBLE)

            // Hide all non-overlay buttons
            player1Plus.setVisibility(View.GONE)
            player2Plus.setVisibility(View.GONE)

            player1Minus.setVisibility(View.GONE)
            player2Minus.setVisibility(View.GONE)

            settingsButton.setVisibility(View.GONE)
        }

        fun closeOverlay() {
            overlayContainer.setVisibility(View.GONE)

            // Show all player buttons and others when overlay is hidden
            player1Plus.setVisibility(View.VISIBLE)
            player2Plus.setVisibility(View.VISIBLE)

            player1Minus.setVisibility(View.VISIBLE)
            player2Minus.setVisibility(View.VISIBLE)

            settingsButton.setVisibility(View.VISIBLE)
        }

        // Navigates to the home activity
        homeButton.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }

        settingsButton.setOnClickListener {
            openOverlay()
        }

        closeOverlayButton.setOnClickListener {
            closeOverlay()
        }

        resetButton.setOnClickListener {
            closeOverlay()

            player1Life = 40
            player1LifeTextView.text = "$player1Life"
            player2Life = 40
            player2LifeTextView.text = "$player2Life"
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
        player1Minus.setOnLongClickListener {
            player1Life -= 10
            if (player1Life <= 0) {
                player1Life = 0
                player1LifeTextView.text = "R.I.P"
                checkForWinner()
            }
            else {
                player1LifeTextView.text = "$player1Life"
            }
            true
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
        player2Minus.setOnLongClickListener {
            player2Life -= 10
            if (player2Life <= 0) {
                player2Life = 0
                player2LifeTextView.text = "R.I.P"
                checkForWinner()
            }
            else {
                player2LifeTextView.text = "$player2Life"
            }
            true
        }

        // Add life button listeners
        player1Plus.setOnClickListener {
            player1Life++
            player1LifeTextView.text = "$player1Life"
            // Call check for winner in case we need to clear the winning player textview
            checkForWinner()
        }
        player1Plus.setOnLongClickListener {
            player1Life += 10
            player1LifeTextView.text = "$player1Life"
            // Call check for winner in case we need to clear the winning player textview
            checkForWinner()
            true
        }

        player2Plus.setOnClickListener {
            player2Life++
            player2LifeTextView.text = "$player2Life"
            // Call check for winner in case we need to clear the winning player textview
            checkForWinner()
        }
        player2Plus.setOnLongClickListener {
            player2Life += 10
            player2LifeTextView.text = "$player2Life"
            // Call check for winner in case we need to clear the winning player textview
            checkForWinner()
            true
        }
    }
}