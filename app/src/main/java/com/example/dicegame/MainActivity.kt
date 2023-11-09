package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var randomNumberTextView: TextView
    lateinit var randomNumberButton: Button
    lateinit var diceSidesEditText: EditText
    lateinit var diceImage: ImageView
    val die1 = Die()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomNumberTextView = findViewById(R.id.randomNumberTextView)
        randomNumberButton = findViewById(R.id.randomNumberButton)
        diceSidesEditText = findViewById(R.id.diceSidesEditText)
        diceImage = findViewById(R.id.diceImage)

        diceImage.setOnClickListener{
            toggleHold(die1)
        }
        randomNumberButton.setOnClickListener{
            generateNewRandomNumber()
            }
    }

    fun generateNewRandomNumber(){
        die1.roll()
        diceImage.setImageResource(die1.getImageIndex())
        randomNumberTextView.text = die1.value.toString()
    }

    fun toggleHold(die: Die){
        diceImage.setImageResource(die.toggleHold())
    }

}