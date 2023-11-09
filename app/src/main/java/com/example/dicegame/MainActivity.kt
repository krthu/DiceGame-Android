package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    lateinit var randomNumberButton: Button

    lateinit var diceImage: ImageView
    val die1 = Die()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomNumberButton = findViewById(R.id.randomNumberButton)
        diceImage = findViewById(R.id.diceImage2)

        diceImage.setOnClickListener {
            toggleHold(die1)
        }
        randomNumberButton.setOnClickListener {
            generateNewRandomNumber()
        }
    }

    fun generateNewRandomNumber() {
        die1.roll()
        diceImage.setImageResource(die1.getImageIndex())

    }

    fun toggleHold(die: Die) {
        diceImage.setImageResource(die.toggleHold())
    }

}