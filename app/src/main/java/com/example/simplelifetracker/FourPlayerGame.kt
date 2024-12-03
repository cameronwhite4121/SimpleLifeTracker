package com.example.simplelifetracker

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class FourPlayerGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_four_player_game)
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

        // Initialize hidden overlay
        val overlayContainer: View = findViewById(R.id.overlayContainer)

        // Set life totals
        var player1Life = 40
        player1LifeTextView.text = "$player1Life"
        var player2Life = 40
        player2LifeTextView.text = "$player2Life"
        var player3Life = 40
        player3LifeTextView.text = "$player3Life"
        var player4Life = 40
        player4LifeTextView.text = "$player4Life"

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
            if (player4Life == 0) {
                numPlayerRip++
            }
            // If there is a winner, display the winner
            if (numPlayerRip == 3) {
                if (player1Life != 0) {
                    winningPlayer.text = "Player 1 wins!"
                }
                if (player2Life != 0) {
                    winningPlayer.text = "Player 2 wins!"
                }
                if (player3Life != 0) {
                    winningPlayer.text = "Player 3 wins!"
                }
                if (player4Life != 0) {
                    winningPlayer.text = "Player 4 wins!"
                }
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
            player3Plus.setVisibility(View.GONE)
            player4Plus.setVisibility(View.GONE)

            player1Minus.setVisibility(View.GONE)
            player2Minus.setVisibility(View.GONE)
            player3Minus.setVisibility(View.GONE)
            player4Minus.setVisibility(View.GONE)

            settingsButton.setVisibility(View.GONE)
        }

        fun closeOverlay() {
            overlayContainer.setVisibility(View.GONE)

            // Show all player buttons and others when overlay is hidden
            player1Plus.setVisibility(View.VISIBLE)
            player2Plus.setVisibility(View.VISIBLE)
            player3Plus.setVisibility(View.VISIBLE)
            player4Plus.setVisibility(View.VISIBLE)

            player1Minus.setVisibility(View.VISIBLE)
            player2Minus.setVisibility(View.VISIBLE)
            player3Minus.setVisibility(View.VISIBLE)
            player4Minus.setVisibility(View.VISIBLE)

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
            player3Life = 40
            player3LifeTextView.text = "$player3Life"
            player4Life = 40
            player4LifeTextView.text = "$player4Life"
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
        player4Minus.setOnClickListener {
            player4Life--
            if (player4Life <= 0) {
                player4Life = 0
                player4LifeTextView.text = "R.I.P"
                checkForWinner()
            }
            else {
                player4LifeTextView.text = "$player4Life"
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
        player4Plus.setOnClickListener {
            player4Life++
            player4LifeTextView.text = "$player4Life"
            // Call check for winner in case we need to clear the winning player textview
            checkForWinner()
        }
    }
}