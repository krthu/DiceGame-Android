package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {


    private lateinit var rollButton: Button
    private lateinit var numberOfRollsTextView: TextView
    private lateinit var recordTextView: TextView
    private val diceImageViews = mutableListOf<DieView>()
    //private val dice = mutableListOf<Die>()
    private val numberOfDice = 5
    private var numberOfRolls = 0
    private var record = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createDiceImageViews()
        numberOfRollsTextView = findViewById(R.id.timesRolledTextView)
        recordTextView = findViewById(R.id.recordTextView)
        rollButton = findViewById(R.id.randomNumberButton)
        rollButton.setOnClickListener {
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
                imageView.die.toggleHold()
                imageView.setImageResource(imageView.getImageIndex())

            }
            imageView.isVisible = false
        }

    }

    fun rollDice() {
        diceImageViews.forEachIndexed { index, view ->
            view.isVisible = true
            view.die.roll()
            view.setImageResource(view.getImageIndex())
        }
        numberOfRolls++
        numberOfRollsTextView.text = "Times Rolled: ${numberOfRolls}"
        allOfAKind()
    }

    fun allOfAKind() : Boolean{
        var dieValue = 0
        diceImageViews.forEach {view ->
            if ( dieValue == 0){
                dieValue = view.die.value
            } else if (dieValue != view.die.value){
                return false
            }
        }
        checkRecord(numberOfRolls)
        numberOfRollsTextView.text = "It took you ${numberOfRolls} rolls to get all of a kind."
        rollButton.text = "Start Over"
        rollButton.setOnClickListener{
            resetGame()
        }
        return true
    }
    fun resetGame(){
        diceImageViews.forEach{view ->
            view.die.isHeld = false

        }
        rollDice()
        numberOfRolls = 1
        numberOfRollsTextView.text = "Times Rolled: ${numberOfRolls}"
        rollButton.text = "Roll"
        rollButton.setOnClickListener{
            rollDice()
        }

    }
    fun checkRecord(timesRolled: Int) {
        recordTextView.isVisible = true
        if (record == 0 || record > timesRolled){
            record = timesRolled
        }
        recordTextView.text = "Record: ${record}"
    }

}