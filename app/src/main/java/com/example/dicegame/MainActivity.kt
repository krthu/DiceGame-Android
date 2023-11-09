package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var randomNumberButton: Button
    private lateinit var numberOfRollsTextView: TextView
    private val diceImageViews = mutableListOf<ImageView>()
    private val dice = mutableListOf<Die>()
    private val numberOfDice = 5
    private var numberOfRolls = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createDice()
        createDiceImageViews()
        numberOfRollsTextView = findViewById(R.id.timesRolledTextView)
        randomNumberButton = findViewById(R.id.randomNumberButton)
        randomNumberButton.setOnClickListener {
            rollDice()
        }
    }

    fun createDiceImageViews(){
        diceImageViews.add(findViewById(R.id.diceImage1))
        diceImageViews.add(findViewById(R.id.diceImage2))
        diceImageViews.add(findViewById(R.id.diceImage3))
        diceImageViews.add(findViewById(R.id.diceImage4))
        diceImageViews.add(findViewById(R.id.diceImage5))
        diceImageViews.forEachIndexed { index, imageView ->
            imageView.setOnClickListener{
                imageView.setImageResource(dice[index].toggleHold())
            }

        }

    }

    fun createDice(){
        for (i in 1..numberOfDice){
            dice.add(Die())
        }
    }

    fun rollDice() {
        dice.forEachIndexed { index, die ->  
            die.roll()
            diceImageViews[index].setImageResource(die.getImageIndex())
        }
        numberOfRolls++
        numberOfRollsTextView.text = "Times Rolled: ${numberOfRolls}"
    }
}