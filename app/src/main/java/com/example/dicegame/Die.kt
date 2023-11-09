package com.example.dicegame

class Die {
    private var sides = 6
    private var value = 1
    private var isHeld = false

    fun roll() {
        if (!isHeld) {
            value = (1..sides).shuffled().first()
        }
    }

    fun getImageIndex(): Int {
        if (!isHeld) {
            return when (value) {
                1 -> R.drawable.dice1
                2 -> R.drawable.dice2
                3 -> R.drawable.dice3
                4 -> R.drawable.dice4
                5 -> R.drawable.dice5
                else -> R.drawable.dice6
            }
        }
        return when (value) {
            1 -> R.drawable.dice1held
            2 -> R.drawable.dice2held
            3 -> R.drawable.dice3held
            4 -> R.drawable.dice4held
            5 -> R.drawable.dice5held
            else -> R.drawable.dice6held
        }
    }

    fun toggleHold(): Int {
        isHeld = !isHeld
        return getImageIndex()
    }
}