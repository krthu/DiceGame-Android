package com.example.dicegame


class Die {
    var sides = 6
    var value = 1
    var isHeld = false

    fun roll(){
        if (!isHeld){
            value = (1..sides).shuffled().first()
        }

    }
    fun toggleHold(){
        isHeld = !isHeld
    }
}