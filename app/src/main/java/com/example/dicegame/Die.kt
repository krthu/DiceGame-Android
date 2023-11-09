package com.example.dicegame

class Die {
    private var sides = 6
    internal var value = 1
    internal var isHeld = false

    fun roll() {
        if (!isHeld) {
            value = (1..sides).shuffled().first()
        }
    }



    fun toggleHold() {
        isHeld = !isHeld
    }
}