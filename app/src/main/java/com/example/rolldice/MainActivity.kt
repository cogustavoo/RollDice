package com.example.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.buttom)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    // gira o dado e faz updade na tela com o resultado
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.diceView)

        //determina qual imagem vai ser usada no resultado
        val drawaleResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.contentDescription = diceRoll.toString()
        diceImage.setImageResource(drawaleResource)
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int = (1..6).random()
}