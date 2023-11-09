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
        when (die1.value){
            1 -> diceImage.setImageResource(R.drawable.dice1)
            2 -> diceImage.setImageResource(R.drawable.dice2)
            3 -> diceImage.setImageResource(R.drawable.dice3)
            4 -> diceImage.setImageResource(R.drawable.dice4)
            5 -> diceImage.setImageResource(R.drawable.dice5)
            6 -> diceImage.setImageResource(R.drawable.dice6)
        }
        randomNumberTextView.text = die1.value.toString()
    }

    fun toggleHold(die: Die){
        die.toggleHold()
        var imageName: String
        if (die.isHeld){
            imageName = "dice${die.value}held"
        }else{
            imageName = "dice${die.value}"
        }
        val imageResId = resources.getIdentifier(imageName, "drawable", packageName)
        diceImage.setImageResource(imageResId)
    }

}