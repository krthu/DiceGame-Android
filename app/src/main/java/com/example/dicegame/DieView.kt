package com.example.dicegame

import android.content.Context

import android.util.AttributeSet


class DieView: androidx.appcompat.widget.AppCompatImageView {
    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context , attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    internal val die = Die()

    fun getImageIndex(): Int {
        if (!die.isHeld) {
            return when (die.value) {
                1 -> R.drawable.dice1
                2 -> R.drawable.dice2
                3 -> R.drawable.dice3
                4 -> R.drawable.dice4
                5 -> R.drawable.dice5
                else -> R.drawable.dice6
            }
        }
        return when (die.value) {
            1 -> R.drawable.dice1held
            2 -> R.drawable.dice2held
            3 -> R.drawable.dice3held
            4 -> R.drawable.dice4held
            5 -> R.drawable.dice5held
            else -> R.drawable.dice6held
        }
    }

}