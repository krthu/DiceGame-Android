package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class scoreboardActivity : AppCompatActivity() {
    private lateinit var backButton: Button
    private lateinit var rvScoreItems: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)
        rvScoreItems = findViewById(R.id.rvScoreItems)
        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
        var scoreItems = mutableListOf(
            scoreItem("1", 0, false),
            scoreItem("2", 8, true),
            scoreItem("3", 0, false),
            scoreItem("4", 16, true),
        )
        val adapter = scoreAdapter(scoreItems)
        rvScoreItems.adapter = adapter
        rvScoreItems.layoutManager = LinearLayoutManager(this)
    }
}